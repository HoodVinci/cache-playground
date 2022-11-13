plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.playground.cache.server.ServerKt")
}

dependencies {
    implementation(projects.models)
    implementation(projects.datastore)
    implementation(Libs.okio)
    implementation(Libs.Ktor.Server.core)
    implementation(Libs.Ktor.Server.netty)
    implementation(Libs.Ktor.Server.logger)
    implementation(Libs.Ktor.Logger.logBack)
    implementation(Libs.Ktor.Server.cachingHeaders)
    implementation(Libs.Ktor.Server.conditionalHeaders)
    implementation(Libs.Ktor.Server.contentNegotiation)
    implementation(Libs.Ktor.Json.jsonSerialization)
    implementation(Libs.kotlinxSerializationJson)
}
