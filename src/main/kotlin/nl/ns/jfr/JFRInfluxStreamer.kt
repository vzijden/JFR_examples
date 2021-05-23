package nl.ns.jfr

import jdk.jfr.FlightRecorder
import jdk.jfr.consumer.RecordingStream
import org.influxdb.InfluxDBFactory
import org.influxdb.dto.Point
import java.util.concurrent.TimeUnit

class JFRInfluxStreamer {
    val influxDBFactory = InfluxDBFactory.connect("http://grafana.local:8086", "jfr", "jfr")
    val fr = FlightRecorder.register(RestCallEvent::class.java)

    init {
        influxDBFactory.setDatabase("jfr")
        val recordingStream = RecordingStream()
        recordingStream.enable(RestCallEvent::class.java)

        recordingStream.onEvent {
            influxDBFactory.write(
                Point.measurement("Rest_invocation")
                    .time(it.startTime.toEpochMilli(), TimeUnit.MILLISECONDS)
                    .addField("duration", it.duration.nano)
                    .addField("endpoint", it.getString("endpoint"))
                    .build()
            )
        }

        recordingStream.startAsync()
    }


}