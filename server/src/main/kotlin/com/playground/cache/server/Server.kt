package com.playground.cache.server

import com.playground.cache.store.createVersionStore
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {

    val store = createVersionStore()

    embeddedServer(Netty, port = 8080) {
        configure(store)
        route(store)
    }.start(wait = true)

}
