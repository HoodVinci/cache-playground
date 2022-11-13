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
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import io.ktor.util.*
import kotlinx.datetime.toJavaInstant
import org.slf4j.event.Level

fun Application.route(store: VersionStore) {
    routing {
        get("/versions") { call.respond(store.get()) }
    }
}
