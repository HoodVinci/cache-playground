package com.playground.cache.backend

import com.playground.cache.models.Version
import com.playground.cache.store.createVersionStore


fun main(args: Array<String>) {
    val versionStore = createVersionStore()

    versionStore.add(readVersionFromCli())
}

private fun readVersionFromCli(): Version {
    println("Enter title :")
    val title: String = readln()

    println("Enter description :")
    val description: String = readln()
    return Version(title, description)
}