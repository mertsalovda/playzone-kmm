package ktor.models

import kotlinx.serialization.SerialName
import models.Game

@kotlinx.serialization.Serializable
data class KtorSearchGame(
    @SerialName("gameId")
    val gameId: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("version")
    val version: String,
    @SerialName("size")
    val size: String,
)

fun KtorSearchGame.mapToGame(): Game =
    Game(
        gameId = gameId,
        title = title
    )