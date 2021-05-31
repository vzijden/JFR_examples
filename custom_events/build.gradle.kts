plugins {
    id("io.quarkus") version "1.13.6.Final"
}


dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:1.13.6.Final"))
    implementation("io.quarkus:quarkus-resteasy:1.13.6.Final")
}
