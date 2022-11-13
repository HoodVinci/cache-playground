

plugins {
    id("multiplatform-conventions")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies{
                api(projects.models)
                implementation(Libs.okio)
                api(Libs.datetime)
                implementation(Libs.kotlinxSerializationJson)
            }
        }
    }
}
