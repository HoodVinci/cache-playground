plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.playground.cache.device.DeviceKt")
}

dependencies {
    implementation(projects.client)
    implementation(Libs.coroutines)
}
