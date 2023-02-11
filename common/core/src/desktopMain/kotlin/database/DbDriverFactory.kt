package database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import PlatformConfiguration

actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver {
        return JdbcSqliteDriver(url = "jdbc:sqlite:build")
    }
}