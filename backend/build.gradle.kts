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
}
