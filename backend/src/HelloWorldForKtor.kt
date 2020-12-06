package jp.kght6123.ktor.helloworld

import java.util.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.swagger.experimental.*

data class Hello(
    val id: Long,
    val category: Category,
    val name: String,
    val tags: List<Tag>,
    val status: String
) {
    init {
        status.verifyParam("status") { it in setOf("available", "pending", "sold") }
    }
}

data class Category(
    val id: Long,
    val name: String
)

data class Tag(
    val id: Long,
    val name: String
)
