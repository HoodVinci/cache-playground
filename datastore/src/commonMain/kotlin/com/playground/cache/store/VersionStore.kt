package com.playground.cache.store

import com.playground.cache.models.Version
import kotlinx.datetime.Instant

interface VersionStore {

    fun add(version: Version)

    fun get(): List<Version>

    fun getLastModification(): Instant

    fun getContentHash(): String

}



expect fun createVersionStore() :VersionStore