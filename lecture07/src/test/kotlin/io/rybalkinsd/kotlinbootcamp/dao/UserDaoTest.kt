package io.rybalkinsd.kotlinbootcamp.dao

import io.rybalkinsd.kotlinbootcamp.db.DbConnector
import io.rybalkinsd.kotlinbootcamp.model.toUser
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

@Ignore
class UserDaoTest {

    @Before
    fun setUp() {
        DbConnector
    }

    @Test
    fun `insert user`() {
        transaction {
            addLogger(StdOutSqlLogger)

            val id = Users.insert {
                it[id] = 44
                it[login] = "login44"
            } get Users.id

            println(id)
        }
    }

    @Test
    fun `select * from User`() {
        transaction {
            addLogger(StdOutSqlLogger)

            val users = Users.selectAll().map {
                it.toUser()
            }

            println(users)
        }
    }
}