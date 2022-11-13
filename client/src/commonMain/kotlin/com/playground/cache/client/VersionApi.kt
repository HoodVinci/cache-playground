package com.playground.cache.client

import com.playground.cache.client.internal.KtorVersionsApi
import com.playground.cache.models.Version

interface VersionApi {
    suspend fun getVersions(): List<Version>
}


fun createApi(serverUrl: String): VersionApi = KtorVersionsApi(serverUrl)