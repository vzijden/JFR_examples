plugins {
    application
}

application {
    mainClass.set("nl.ns.ApplicationKt")
}

val ktorVersion = "1.5.4"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.30")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.influxdb:influxdb-java:2.21")
}
