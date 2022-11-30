object Libs {

    private const val coroutinesVersion = "1.6.3"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"

    const val mockk = "io.mockk:mockk:1.12.4"

    const val okio = "com.squareup.okio:okio:3.2.0"

    const val okhttp = "com.squareup.okhttp3:okhttp:4.5.0"

    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"

    const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"

    object Ktor {
        private const val ktorVersion = "2.1.3"
        private const val loggerVersion = "1.2.11"


        object Client {
            const val core = "io.ktor:ktor-client-core:$ktorVersion"
            const val cio = "io.ktor:ktor-client-cio:$ktorVersion"
            const val logging = "io.ktor:ktor-client-logging:$ktorVersion"
            const val jsonSerialization = "io.ktor:ktor-client-serialization:$ktorVersion"
            const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
        }

        object Server {
            const val core = "io.ktor:ktor-server-core-jvm:$ktorVersion"
            const val netty = "io.ktor:ktor-server-netty-jvm:$ktorVersion"

            const val logger = "io.ktor:ktor-server-call-logging:$ktorVersion"
            const val cachingHeaders = "io.ktor:ktor-server-caching-headers:$ktorVersion"
            const val conditionalHeaders = "io.ktor:ktor-server-conditional-headers:$ktorVersion"
            const val contentNegotiation = "io.ktor:ktor-server-content-negotiation:$ktorVersion"
        }

        object Logger {
            const val logBack = "ch.qos.logback:logback-classic:$loggerVersion"
        }
        object Json {
            const val jsonSerialization = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
        }
    }
}
