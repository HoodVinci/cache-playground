object Libs {

    private const val coroutinesVersion = "1.6.3"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"

    const val mockk = "io.mockk:mockk:1.12.4"

    const val okio = "com.squareup.okio:okio:3.2.0"

    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"

    object Ktor {
        private const val ktorVersion = "2.1.3"
        private const val loggerVersion = "1.2.11"
        const val serverCore = "io.ktor:ktor-server-core-jvm:$ktorVersion"
        const val serverNetty = "io.ktor:ktor-server-netty-jvm:$ktorVersion"
        const val logBack = "ch.qos.logback:logback-classic:$loggerVersion"
        const val logger = "io.ktor:ktor-server-call-logging:$ktorVersion"
        const val cachingHeaders = "io.ktor:ktor-server-caching-headers:$ktorVersion"
        const val conditionalHeaders = "io.ktor:ktor-server-conditional-headers:$ktorVersion"
    }


}
