package jp.kght6123.ktor.helloworld.service

import jp.kght6123.ktor.helloworld.factory.DatabaseFactory.dbQuery
import jp.kght6123.ktor.helloworld.model.Hello
import jp.kght6123.ktor.helloworld.model.HelloData
import jp.kght6123.ktor.helloworld.model.NewHelloData
import org.jetbrains.exposed.sql.*

class HelloService {
    suspend fun getAll(): List<HelloData> = dbQuery {
        Hello.selectAll().map { convert(it) }
    }
    suspend fun get(id: Int): HelloData? = dbQuery {
        Hello.select {
            (Hello.id eq id)
        }.mapNotNull { convert(it) }
            .singleOrNull()
    }
    suspend fun add(helloData: NewHelloData): HelloData {
        var key = 0
        dbQuery {
            key = (Hello.insert {
                it[hello] = helloData.hello
            } get Hello.id)
        }
        return get(key)!!
    }
    suspend fun update(helloData: NewHelloData): HelloData? {
        val id = helloData.id
        return if (id == null) {
            add(helloData)
        } else {
            dbQuery {
                Hello.update({ Hello.id eq id }) {
                    it[hello] = helloData.hello
                } }
            get(id)
        }
    }
    suspend fun delete(id: Int): Boolean {
        return dbQuery {
            Hello.deleteWhere { Hello.id eq id } > 0
        }.also {
            false
        }
    }
    private fun convert(row: ResultRow): HelloData =
        HelloData(id = row[Hello.id], hello = row[Hello.hello])
}