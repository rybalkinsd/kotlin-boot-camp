package io.rybalkinsd.kotlinbootcamp.dao

import org.jetbrains.exposed.sql.Table

object Users : Table("chat.user") {
    val id = integer("id").autoIncrement().primaryKey()
    val login = text("login")
}

object Messages : Table("chat.message") {
    val id = integer("id").autoIncrement().primaryKey()
    val user = integer("user") references Users.id
    val time = datetime("time")
    val value = text("value")
}