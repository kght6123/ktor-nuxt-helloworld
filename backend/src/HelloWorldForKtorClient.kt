package jp.kght6123.ktor.helloworld

import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Hello World for Ktor Client
 * 
 * Hello World.
 */
open class HelloWorldForKtorClient(val endpoint: String, val client: HttpClient = HttpClient()) {
    /**
     * Add a new hello to the store
     * 
     * @param body hello object that needs to be added to the store
     * 
     * @return OK
     */
    suspend fun addHello(
        body: Hello // BODY
    ): String {
        return client.post<String>("$endpoint/hello") {
            this.body = mutableMapOf<String, Any?>().apply {
                this["body"] = body
            }
        }
    }
}
