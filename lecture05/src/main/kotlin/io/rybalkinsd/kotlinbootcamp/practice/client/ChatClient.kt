package io.rybalkinsd.kotlinbootcamp.practice.client

import com.kohttp.dsl.httpPost
import okhttp3.Response

object ChatClient {
    // Change to server url
    private const val HOST = "localhost"
    private const val PORT = 8080

    /**
     * POST /chat/login?name=my_name
     */
    fun login(name: String) = httpPost {
        host = HOST
        port = PORT
        path = "/chat/login"
        body {
            form {
                "name" to name
            }
        }
    }

    /**
     * GET /chat/history
     */
    fun viewHistory(): Response = TODO()

    /**
     * POST /chat/say
     *
     * Body: "name=my_name&msg='my_message'"
     */
    fun say(name: String, msg: String): Response = TODO()

    /**
     * GET /chat/online
     */
    fun viewOnline(): Response = TODO()

    /**
     * POST /chat/logout?name=my_name
     */
    fun logout(name: String): Response = TODO()
}
