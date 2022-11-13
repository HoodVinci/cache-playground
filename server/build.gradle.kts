plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.playground.cache.backend.BackendKt")
}

dependencies {
    implementation(projects.models)
    implementation(projects.datastore)
    implementation(Libs.okio)
    implementation(Libs.Ktor.serverCore)
    implementation(Libs.Ktor.serverNetty)
    implementation(Libs.Ktor.logger)
    implementation(Libs.Ktor.logBack)
    implementation(Libs.Ktor.cachingHeaders)
    implementation(Libs.Ktor.conditionalHeaders)
}
