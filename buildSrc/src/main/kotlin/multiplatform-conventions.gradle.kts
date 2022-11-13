plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        testRuns["test"].executionTask.configure {
            // enable TestNG support
            useTestNG()
            // or
            // enable JUnit Platform (a.k.a. JUnit 5) support
            useJUnitPlatform()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(Libs.coroutines)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(Libs.mockk)
                implementation(kotlin("test"))
            }
        }
    }
}

