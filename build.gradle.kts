import kotlin.time.milliseconds

plugins {
//    id("org.jetbrains.kotlin.jvm") version "1.4.30"
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


        val rootPath = this.project.rootProject.rootDir
        jvmArgs("-Xmx512m", "-XX:StartFlightRecording=dumponexit=true,settings=${rootPath}/JFRConfig.jfc,filename=/tmp/jfrdump-${getTime()}.jfr,path-to-gc-roots=true")
    }

    tasks.withType<Jar>().configureEach {
        manifest.attributes["Main-Class"] = "nl.ns.jfr.Main"
    }

}

@OptIn(kotlin.time.ExperimentalTime::class)
fun getTime(): String {
    return System.currentTimeMillis().milliseconds.toIsoString()
}