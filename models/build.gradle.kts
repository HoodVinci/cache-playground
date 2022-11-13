

plugins {
    id("multiplatform-conventions")
    kotlin("plugin.serialization") version "1.7.20"
}

kotlin {
    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation(Libs.kotlinxSerializationJson)
            }
        }
    }
}
