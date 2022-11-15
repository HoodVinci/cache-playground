package com.playground.cache.device

import com.playground.cache.client.createApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds


fun main(args: Array<String>) {

    val client = createApi("http://0.0.0.0:8080")

    runBlocking {
        repeat(20) {
            println("device call n°$it ${client.getVersions()}")
            delay(10.seconds)
        }
    }
}
