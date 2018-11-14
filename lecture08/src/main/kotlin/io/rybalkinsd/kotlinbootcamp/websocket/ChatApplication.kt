package io.rybalkinsd.kotlinbootcamp.websocket

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.ConcurrentHashMap

data class User(val id: Long, val name: String)
data class Message(val msgType: String, val data: Any)

class ChatHandler : TextWebSocketHandler() {
    private val connections = ConcurrentHashMap<WebSocketSession, User>()
    var uids = AtomicLong(0)

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        connections -= session
    }

    public override fun handleTextMessage(session: WebSocketSession?, message: TextMessage?) {
        val json = ObjectMapper().readTree(message?.payload)
        // {type: "login/say", data: "name/msg"}
        when (json["type"].asText()) {
            "login" -> {
                val user = User(uids.getAndIncrement(), json["data"].asText())
                connections[session!!] = user
                // tell this user about all other users
                emit(session, Message("online", connections.values))
                // tell all other users, about this user
                broadcastToOthers(session, Message("login", user))
            }
            "say" -> {
                broadcast(Message("say", json["data"].asText()))
            }
        }
    }

    fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(TextMessage(jacksonObjectMapper().writeValueAsString(msg)))
    fun broadcast(msg: Message) = connections.forEach { emit(it.key, msg) }
    fun broadcastToOthers(me: WebSocketSession, msg: Message) = connections.filterNot { it.key == me }.forEach { emit(it.key, msg) }
}

@Configuration
@EnableWebSocket
class WSConfig : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry
                //Attach ChatHandler to /chat url
                .addHandler(ChatHandler(), "/chat")
                //SockJS is a fallback WebSocket implementation that is used if browser does not support websocket
                .withSockJS()
    }
}

@SpringBootApplication
class ChatApplication

fun main(args: Array<String>) {
    runApplication<ChatApplication>(*args)
}