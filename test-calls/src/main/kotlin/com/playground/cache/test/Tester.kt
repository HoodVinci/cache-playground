package com.playground.cache.test

import okhttp3.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds


fun main(args: Array<String>) {
    val client: OkHttpClient = OkHttpClient().newBuilder().build()

    println(client.makeRequest().code)
    println(client.makeRequestAndGetSize())

    val average = (0..10).map { client.makeRequestAndGetDuration() }
        .reduceRight { duration, acc -> acc + duration / 2 }

    println(average)


}

private fun OkHttpClient.makeRequestAndGetDuration(): Duration {

    val response: Response = makeRequest()
    return (response.receivedResponseAtMillis - response.sentRequestAtMillis).milliseconds
}

private fun OkHttpClient.makeRequestAndGetSize(): Long? = makeRequest().body.contentLength()


private fun OkHttpClient.makeRequest(): Response {
    val request: Request = Request.Builder()
        .cacheControl(CacheControl.FORCE_NETWORK)
        .url("https://api.radiofrance.fr/v1/stations/7/steps-from-datetime?filter%5Bdepth%5D=3&include=track&include=track.release&direction=past&date-time=2022-11-28T17:14&page[limit]=17&page[offset]=0")
        .addHeader("x-token", "0cbe991e-18ac-4635-ad7f-773257c63797")
        .build()
    return newCall(request).execute()
}