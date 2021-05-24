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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("com.influxdb:influxdb-client-kotlin:2.2.0")
}
