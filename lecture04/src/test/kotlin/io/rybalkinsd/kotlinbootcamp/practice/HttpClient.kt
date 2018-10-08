import com.kohttp.dsl.httpPost
import okhttp3.Response
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.io.IOException

object ChatClient {
    private val HOST = "localhost" // Change to server url
    private val PORT = 8080

    // POST /chat/login?name=my_name
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

    // GET /chat/history
    fun viewHistory(): Response = TODO()

    // POST /chat/say
    // Body: "name=my_name&msg='my_message'"
    fun say(name: String, msg: String): Response = TODO()

    // GET /chat/online
    fun viewOnline(): Response = TODO()

    // POST /chat/logout?name=my_name
    fun logout(name: String): Response = TODO()
}

@Ignore
class ChatClientTest {
    companion object {
        private val MY_NAME_IN_CHAT = "I_DID_NOT_CHANGE_DEFAULT_NAME" // Change this to your Last name
        private val MY_MESSAGE_TO_CHAT = "SOMEONE_KILL_ME" // Change this to any non-swear text
    }

    @Test
    fun login() {
        val response = ChatClient.login(MY_NAME_IN_CHAT)
        println(response)
        Assert.assertTrue(response.code() == 200 || response.code() == 400)
    }

    @Test
    fun viewHistory() {
        val response = ChatClient.viewHistory()
        println(response)
        Assert.assertTrue(response.code() == 200)
    }

    @Test
    fun viewOnline() {
        val response = ChatClient.viewOnline()
        println(response)
        Assert.assertTrue(response.code() == 200)
    }

    @Test
    @Throws(IOException::class)
    fun say() {
        val response = ChatClient.say(MY_NAME_IN_CHAT, MY_MESSAGE_TO_CHAT)
        println(response)
        Assert.assertTrue(response.code() == 200)
    }

    @Test
    fun logout() {
        val response = ChatClient.logout(MY_NAME_IN_CHAT)
        println(response)
        Assert.assertTrue(response.code() == 200 || response.code() == 400)
    }
}