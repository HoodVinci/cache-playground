package com.playground.cache.models

@kotlinx.serialization.Serializable
data class Version(
    val name: String,
    val description: String,
)
