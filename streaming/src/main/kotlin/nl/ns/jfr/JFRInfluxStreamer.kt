package nl.ns.jfr

import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.kotlin.InfluxDBClientKotlinFactory
import com.influxdb.client.write.Point
import jdk.jfr.consumer.RecordingStream
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class JFRInfluxStreamer {
    private val influxDBFactory = InfluxDBClientKotlinFactory.create(
        "http://localhost:8086", "token".toCharArray(), "NS", "JFR"
    )
    init {
        val recordingStream = RecordingStream()
        recordingStream.enable(RestCallEvent::class.java)

        recordingStream.onEvent {
            val writeApi = influxDBFactory.getWriteKotlinApi()
            GlobalScope.launch {
                writeApi.writePoint(
                    Point.measurement("rest")
                        .time(it.startTime.toEpochMilli(), WritePrecision.MS)
                        .addField("duration", it.duration.nano)
                        .addTag("endpoint", it.getString("endpoint"))

                )
            }
        }

        recordingStream.startAsync()
    }


}