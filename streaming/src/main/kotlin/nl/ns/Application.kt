package nl.ns

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import kotlinx.coroutines.delay
import nl.ns.jfr.JFRInfluxStreamer
import nl.ns.jfr.RestCallEvent
import kotlin.time.seconds
import kotlin.time.ExperimentalTime

@ExperimentalTime
fun main() {
    JFRInfluxStreamer()
    embeddedServer(Netty, port = 8000) {
        routing {
            get("/hoiVincent") {
                call.respondText("Hallo Rick!")

            }
            get("/slow") {
                delay(2.seconds)
                call.respondText("This took a while")
            }

            val eventAttributeKey = AttributeKey<RestCallEvent>("event")
            intercept(ApplicationCallPipeline.Setup) {
                val restCallEvent = RestCallEvent(this.context.request.uri)
                restCallEvent.begin()
                this.context.attributes.put(eventAttributeKey, restCallEvent)
            }

            sendPipeline.intercept(ApplicationSendPipeline.After) {
                this.context.attributes.getOrNull(eventAttributeKey)?.apply {
                    commit()
                }
            }
        }


    }.start(wait = true)

}


