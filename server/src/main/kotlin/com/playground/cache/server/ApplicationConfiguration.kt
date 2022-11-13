package com.playground.cache.server

import com.playground.cache.store.VersionStore
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.conditionalheaders.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.util.*
import io.ktor.util.*
import kotlinx.datetime.toJavaInstant
import org.slf4j.event.Level


fun Application.configure(store: VersionStore) {
    configureNegotiation()
    configureCaching(store)
    configureLogging()
}

private fun Application.configureNegotiation() {
    install(ContentNegotiation) {
        json()
    }
}

private fun Application.configureLogging() {
    install(CallLogging) {
        level = Level.INFO
        format { call ->
            val status = call.response.status()
            val headers = call.request.headers.toMap().toString()
            "Status: $status, Headers: $headers"
        }
    }
}

private fun Application.configureCaching(store: VersionStore) {
    install(CachingHeaders) {
        options { _, _ ->
            CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 60))
        }
    }
    install(ConditionalHeaders) {
        version { _, _ ->
            listOf(
                EntityTagVersion(store.getContentHash()),
                LastModifiedVersion(store.getLastModification().toJavaInstant().toGMTDate())
            )
        }
    }
}
