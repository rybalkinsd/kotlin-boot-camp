package io.rybalkinsd.kotlinbootcamp.network

import io.rybalkinsd.kotlinbootcamp.util.logger
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.util.concurrent.ConcurrentHashMap

class ConnectionPool {
    private val connections = ConcurrentHashMap<WebSocketSession, User>()

    fun send(session: WebSocketSession,msg: String) {
        if (session.isOpen) {
            session.sendMessage(TextMessage(msg))
        }
    }

    fun broadcast(msg: String) {
        connections.forEach { session, _ -> send(session, msg) }
    }

    fun shutdown() {
        connections.forEach { session, _ ->
            if (session.isOpen) {
                session.close()
            }
        }
    }

    fun getPlayer(session: WebSocketSession): User? = connections[session]

    fun getSession(player: User): WebSocketSession? = connections.entries.asSequence()
        .filter { it.value == player }
        .map { it.key }
        .firstOrNull()

    fun add(session: WebSocketSession, player: User) {
        connections.putIfAbsent(session, player).also {
            if (it == null) log.info("$player joined")
        }
    }

    companion object {
        private val log = logger()
    }
}