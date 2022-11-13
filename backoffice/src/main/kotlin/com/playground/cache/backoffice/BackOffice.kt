package com.playground.cache.backoffice

import com.playground.cache.models.Version
import com.playground.cache.store.createVersionStore


fun main(args: Array<String>) {
    val versionStore = createVersionStore()

    versionStore.add(readVersionFromCli())
}

private fun readVersionFromCli(): Version {
    print("Enter title : ")
    val title: String = readln()

    print("Enter description : ")
    val description: String = readln()
    return Version(title, description)
}