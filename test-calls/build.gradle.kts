plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.playground.cache.test.TesterKt")
}

dependencies {
    implementation(Libs.coroutines)
    implementation(Libs.okhttp)
}
