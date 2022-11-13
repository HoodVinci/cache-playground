package com.playground.cache.store

import com.playground.cache.models.Version
import kotlinx.datetime.Instant
import okio.FileSystem
import okio.Path.Companion.toPath

internal class FileVersionStore(
    private val fileSystem: FileSystem
) : VersionStore {

    private val filePath = "versions.list".toPath()

    init {
        fileSystem.openReadWrite(filePath)
    }


    override fun add(version: Version) {
        val versions = listOf(version) + readVersions()
        writeVersions(versions)
    }

    override fun get(): List<Version> = readVersions()

    override fun getLastModification(): Instant =
        Instant.fromEpochMilliseconds(fileSystem.metadata(filePath).lastModifiedAtMillis ?: 0)

    override fun getContentHash(): String = fileSystem
        .read(filePath) { readByteString() }.sha256().base64()

    private fun readVersions() =
        fileSystem
            .read(filePath) { readUtf8() }
            .lines()
            .mapNotNull(::lineToVersion)

    private fun writeVersions(versions: List<Version>) =
        fileSystem
            .write(filePath) {
                writeUtf8(versionsToString(versions))
            }

}

private fun versionsToString(versions: List<Version>) =
    versions.joinToString("\n", transform = ::versionToLine)

private fun versionToLine(version: Version) =
    listOf(version.name, version.description).joinToString(",")

private fun lineToVersion(line: String): Version? = runCatching {
    val serialVersion = line.split(",")
    Version(serialVersion[0], serialVersion[1])
}.getOrNull()

