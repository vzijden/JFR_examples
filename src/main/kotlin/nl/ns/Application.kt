package nl.ns

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import nl.ns.jfr.JFRInfluxStreamer
import nl.ns.jfr.RestCallEvent

fun main() {
    val jfrInfluxStreamer = JFRInfluxStreamer()

    embeddedServer(Netty, port = 8000) {

        routing {
            get("/hoiVincent") {
                val restCallEvent = RestCallEvent(this.context.request.uri)
                restCallEvent.begin()
                call.respondText("Hallo Rick!")
                restCallEvent.commit()
            }
        }
    }.start(wait = true)
}