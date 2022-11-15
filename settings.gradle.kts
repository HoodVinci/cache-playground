rootProject.name = "CachePlayground"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id in setOf("kotlin-android", "kotlin-kapt", "kotlin-android-extensions")) {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }

            if (requested.id.id in setOf("com.android.application", "com.android.feature")) {
                useModule("com.android.tools.build:gradle:7.0.4")
            }


        }
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include("client")
include("models")
include("backoffice")
include("datastore")
include("server")
include("device")
include("presentation")

