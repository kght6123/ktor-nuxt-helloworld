package jp.kght6123.ktor.helloworld

import java.util.*
import io.ktor.config.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.server.testing.*
import io.ktor.swagger.experimental.*
import kotlin.test.*

class SwaggerRoutesTest {
    /**
     * @see HelloWorldForKtorServer.addHello
     */
    @Test
    fun testAddHello() {
        withTestApplication {
            // @TODO: Adjust path as required
            handleRequest(HttpMethod.Post, "/hello") {
                // @TODO: Your body here
                setBodyJson(mapOf<String, Any?>())
            }.apply {
                // @TODO: Your test here
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }

    fun <R> withTestApplication(test: TestApplicationEngine.() -> R): R {
        return withApplication(createTestEnvironment()) {
            (environment.config as MapApplicationConfig).apply {
                put("jwt.secret", "TODO-change-this-supersecret-or-use-SECRET-env")
            }
            application.module()
            test()
        }
    }

    fun TestApplicationRequest.setBodyJson(value: Any?) = setBody(Json.stringify(value))
}
