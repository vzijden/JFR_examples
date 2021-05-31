import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

group = "nl.ns.webcast"
version = "1.0-SNAPSHOT"

allprojects {
    apply {
        plugin("java")
        plugin("application")
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    tasks.withType<JavaExec>().configureEach {
        main = "nl.ns.jfr.Main"

        jvmArgs("-Xmx512m", "-XX:StartFlightRecording=dumponexit=true,filename=/tmp/jfrdump-${getTime()}.jfr,path-to-gc-roots=true")
    }

}

@OptIn(ExperimentalTime::class)
fun getTime(): String {
    return System.currentTimeMillis().milliseconds.toIsoString()
}