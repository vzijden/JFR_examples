package nl.ns.jfr

import jdk.jfr.Event
import jdk.jfr.Label

data class RestCallEvent(
    @Label("endpoint") val endpoint: String
) : Event() {
    companion object {
        const val NAME = "nl.group9.jfr.RestCallEvent"
    }
}