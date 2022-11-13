package com.playground.cache.server

import com.playground.cache.store.VersionStore
import com.playground.cache.store.createVersionStore
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.conditionalheaders.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import io.ktor.util.*
import kotlinx.datetime.toJavaInstant
import org.slf4j.event.Level


fun main(args: Array<String>) {


    val store = createVersionStore()
    embeddedServer(Netty, port = 8080) {

        install(ContentNegotiation) {
            json()
        }
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

        install(CallLogging) {
            level = Level.INFO
            format { call ->
                val status = call.response.status()
                val headers = call.request.headers.toMap().toString()
                "Status: $status, Headers: $headers"
            }
        }
        configureRooting(store)
    }.start(wait = true)
}


private fun Application.configureRooting(store: VersionStore) {
    routing {
        get("/versions") { call.respond(store.get()) }
    }
}

