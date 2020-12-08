package jp.kght6123.ktor.helloworld.factory

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object DatabaseFactory {
    fun init() {
        Database.connect(hikari())
        val flyway = Flyway.configure().dataSource("jdbc:h2:mem:hello_world", "root", "").load()
        flyway.migrate()
    }
    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:mem:hello_world"
        config.username = "root"
        config.password = ""
        config.maximumPoolSize = 1
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        config.validate()
        return HikariDataSource(config)
    }
    suspend fun <T> dbQuery(
        block: suspend () -> T): T =
        newSuspendedTransaction { block() }
}