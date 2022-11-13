package com.playground.cache.store

import okio.FileSystem


actual fun createVersionStore(): VersionStore  = FileVersionStore(FileSystem.SYSTEM)