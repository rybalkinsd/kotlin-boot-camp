package io.rybalkinsd.kotlinbootcamp.practice

import io.rybalkinsd.kotlinbootcamp.dao.MessageDao
import io.rybalkinsd.kotlinbootcamp.db.DbConnector
import io.rybalkinsd.kotlinbootcamp.model.Message
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

@Ignore
class ChatMessageDaoTest {

    val messageDao = MessageDao()

    @Before
    fun setUp() {
        DbConnector
    }

    @Test
    fun `select * from message`() {
        assertTrue(messageDao.all.isNotEmpty())
    }

    @Test
    fun `insert message`() {
        val before = messagesNumber()
        messageDao.insert(dummyMessage())
        val after = messagesNumber()
        assertTrue(before + 1 >= after)
    }

    fun messagesNumber(): Long = TODO()
    fun dummyMessage(): Message = TODO()
}