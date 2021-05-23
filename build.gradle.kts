plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
    application

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        this.jvmTarget = "14"
    }
}

group = "nl.ns.webcast"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

val ktorVersion = "1.5.4"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.influxdb:influxdb-java:2.21")
}

application {
    mainClass.set("nl.group9.ApplicationKt")
}

allprojects {
    apply {
        plugin("java")
    }
}
