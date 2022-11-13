package com.playground.cache.store

import com.playground.cache.store.internal.FileVersionStore
import okio.FileSystem


actual fun createVersionStore(): VersionStore  = FileVersionStore(FileSystem.SYSTEM)