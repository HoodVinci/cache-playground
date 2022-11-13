package com.playground.cache.store.internal

import com.playground.cache.models.Version
import com.playground.cache.models.Versions
import com.playground.cache.store.VersionStore
import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import okio.FileSystem
import okio.Path.Companion.toPath

internal class FileVersionStore(
    private val fileSystem: FileSystem
) : VersionStore {

    private val json = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val filePath = "versions.json".toPath()

    init {
        fileSystem.openReadWrite(filePath)
    }

    override fun add(version: Version) {
        writeVersions(readVersions().prepend(version))
    }

    override fun get(): List<Version> = readVersions().list

    override fun getLastModification(): Instant =
        Instant.fromEpochMilliseconds(fileSystem.metadata(filePath).lastModifiedAtMillis ?: 0)

    override fun getContentHash(): String = fileSystem
        .read(filePath) { readByteString() }.sha256().base64()

    private fun writeVersions(versions: Versions) =
        fileSystem.write(filePath) { writeUtf8(serializeVersions(versions)) }

    private fun readVersions(): Versions = runCatching {
        fileSystem.read(filePath) { deserializeVersions(readUtf8()) }
    }.getOrDefault(Versions(emptyList()))

    private fun deserializeVersions(value: String) = json.decodeFromString(Versions.serializer(), value)
    private fun serializeVersions(versions: Versions): String = json.encodeToString(Versions.serializer(), versions)
}

private fun Versions.prepend(version: Version) = copy(list = listOf(version) + list)
