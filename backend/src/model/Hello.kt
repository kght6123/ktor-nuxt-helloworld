package jp.kght6123.ktor.helloworld.model

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Hello: Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val hello: Column<String> = varchar("hello", 4000)
    override val primaryKey = PrimaryKey(id, name = "PK1_Hello")
}
data class HelloData (
    val id: Int,
    val hello: String
)
data class NewHelloData (
    val id: Int?,
    val hello: String
)
