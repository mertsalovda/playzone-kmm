package sqldelight

import models.Game


class SqlDelightGamesDataSource() {
    suspend fun fetchAllGames(): List<Game> {
        return emptyList()
    }

    suspend fun searchGame(query: String): Game {
        return Game("", "")
    }
}