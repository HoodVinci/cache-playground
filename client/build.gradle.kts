plugins {
    id("multiplatform-conventions")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.models)
                implementation(Libs.Ktor.Client.core)
                implementation(Libs.Ktor.Client.cio)
                implementation(Libs.Ktor.Client.logging)
                implementation(Libs.Ktor.Logger.logBack)
                implementation(Libs.Ktor.Client.contentNegotiation)
                implementation(Libs.Ktor.Client.jsonSerialization)
                implementation(Libs.Ktor.Json.jsonSerialization)
            }
        }
    }
}
