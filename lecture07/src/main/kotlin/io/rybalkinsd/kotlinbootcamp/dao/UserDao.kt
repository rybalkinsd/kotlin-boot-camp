package io.rybalkinsd.kotlinbootcamp.dao

import io.rybalkinsd.kotlinbootcamp.model.User

class UserDao : Dao<User> {
    override val all: List<User>
        get() = TODO("not implemented")

    override fun getAllWhere(vararg conditions: String): List<User> {
        TODO("not implemented")
    }

    override fun insert(t: User) {
        TODO("not implemented")
    }
}
