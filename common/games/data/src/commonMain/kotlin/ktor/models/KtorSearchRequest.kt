package ktor.models

@kotlinx.serialization.Serializable
data class KtorSearchRequest(
    val searchQuery: String,
)