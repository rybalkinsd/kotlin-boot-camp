package io.rybalkinsd.kotlinbootcamp.dao

import io.rybalkinsd.kotlinbootcamp.db.DbConnector
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.junit.Ignore
import org.junit.Test

@Ignore
class MessageDaoTest {

    @Test
    fun `add massage`() {
        DbConnector

        transaction {
            addLogger(StdOutSqlLogger)

            Messages.insert {
                it[id] = 0
                it[user] = 42
                it[time] = DateTime.now()
                it[value] = "My first message"
            }
        }
    }
}