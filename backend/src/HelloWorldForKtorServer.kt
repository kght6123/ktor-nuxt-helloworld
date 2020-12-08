package jp.kght6123.ktor.helloworld

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*
import io.ktor.swagger.experimental.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import jp.kght6123.ktor.helloworld.model.NewHelloData
import jp.kght6123.ktor.helloworld.service.HelloService

/**
 * Hello World for Ktor
 * 
 * Hello World.
 */
class HelloWorldForKtorServer {
    /**
     * hello
     */
//    fun Routing.registerHello() {
//        post("/hello") {
////            val body = call.getBodyParam<Hello>("body")
//
//            if (false) httpException(HttpStatusCode.MethodNotAllowed)
//
//            call.respond("Hello World!!!")
//        }
//    }
    fun Route.hello(todoService: HelloService) {
        route("hello") {
            get("/") {
                call.respond(todoService.getAll())
            }
            get("/{id}") {
                val id = call.parameters["id"]?.toInt()
                    ?: throw IllegalStateException("Must To id")
                val todo = todoService.get(id)
                if (todo == null) call.respond(HttpStatusCode.NotFound)
                else call.respond(todo)
            }
            post("/") {
                val newTodo = call.receive<NewHelloData>()
                call.respond(HttpStatusCode.Created, todoService.add(newTodo))
            }
            put("/{id}") {
                val todo = call.receive<NewHelloData>()
                val updated = todoService.update(todo)
                if (updated == null) call.respond(HttpStatusCode.NotFound)
                else call.respond(HttpStatusCode.OK, updated)
            }
            delete("/{id}") {
                val id = call.parameters["id"]?.toInt()
                    ?: throw IllegalStateException("Must To id");
                val removed = todoService.delete(id)
                if (removed) call.respond(HttpStatusCode.OK)
                else call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}
