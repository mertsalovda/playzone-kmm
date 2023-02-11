import ktor.KtorGamesDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import sqldelight.SqlDelightGamesDataSource

val gamesModule = DI.Module("gamesModule") {

    bind<KtorGamesDataSource>() with singleton {
        KtorGamesDataSource(instance())
    }

    bind<SqlDelightGamesDataSource>() with singleton {
        SqlDelightGamesDataSource()
    }

    bind<GamesRepository>() with singleton {
        GamesRepositoryImpl(instance(), instance())
    }
}