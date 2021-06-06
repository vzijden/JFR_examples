package nl.ns.jfr;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import io.quarkus.runtime.Startup;
import java.time.temporal.ChronoUnit;
import javax.enterprise.context.ApplicationScoped;
import jdk.jfr.RecordingState;
import jdk.jfr.consumer.RecordingStream;

@Startup
@ApplicationScoped
public class JFRInfluxStreamer {

    private final InfluxDBClient influxDBClient = InfluxDBClientFactory.create(
            "http://localhost:8086", "token".toCharArray(), "NS", "JFR"
    );

    public JFRInfluxStreamer() {
        RecordingStream recordingStream = new RecordingStream();
        recordingStream.enable(RestCallEvent.class);

        recordingStream.onEvent(recordedEvent -> {
            influxDBClient.getWriteApi()
                    .writePoint(
                            new Point("RestCallEvent")
                                    .time(recordedEvent.getStartTime().toEpochMilli(), WritePrecision.MS)
                                    .addField("duration", recordedEvent.getDuration().get(ChronoUnit.MILLIS))
                                    .addField("endpoint",recordedEvent.getValue("endpoint").toString())
                                    .addField("ip", recordedEvent.getValue("ip").toString()));
        });

        recordingStream.startAsync();
    }
}
