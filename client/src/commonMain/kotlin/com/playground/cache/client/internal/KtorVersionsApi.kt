package com.playground.cache.client.internal

import com.playground.cache.client.VersionApi
import com.playground.cache.models.Version
import com.playground.cache.models.Versions
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*


internal class KtorVersionsApi(
    private val baseUrl: String
) : VersionApi {

    private val client = HttpClient(CIO) {
        install(HttpCache)
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun getVersions(): List<Version> =
        client.get("$baseUrl/versions").body()


}