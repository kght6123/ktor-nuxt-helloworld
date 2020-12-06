package jp.kght6123.ktor.helloworld

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*
import io.ktor.swagger.experimental.*
import io.ktor.auth.*
import io.ktor.http.*

/**
 * Hello World for Ktor
 * 
 * Hello World.
 */
class HelloWorldForKtorServer() {
    /**
     * hello
     */
    fun Routing.registerHello() {
        post("/hello") {
            val body = call.getBodyParam<Hello>("body") 

            if (false) httpException(HttpStatusCode.MethodNotAllowed)

            call.respond("Hello World!!!")
        }
    }
}
