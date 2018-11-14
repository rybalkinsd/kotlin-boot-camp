package io.rybalkinsd.kotlinbootcamp.dao

import io.rybalkinsd.kotlinbootcamp.model.Message

class MessageDao : Dao<Message> {
    override val all: List<Message>
        get() = TODO("not implemented")

    override fun getAllWhere(vararg conditions: String): List<Message> {
        TODO("not implemented")
    }

    override fun insert(t: Message) {
        TODO("not implemented")
    }
}
