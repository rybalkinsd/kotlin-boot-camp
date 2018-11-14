package io.rybalkinsd.kotlinbootcamp.practice

import io.rybalkinsd.kotlinbootcamp.dao.UserDao
import io.rybalkinsd.kotlinbootcamp.db.DbConnector
import io.rybalkinsd.kotlinbootcamp.model.User
import junit.framework.TestCase
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import kotlin.random.Random

/**
 * Created by sergey on 3/25/17.
 */
@Ignore
class ChatUserDaoTest {
    val userDao = UserDao()

    @Before
    fun setUp() {
        DbConnector
    }

    @Test
    fun getAllTest() {
        assertTrue(userDao.all.isNotEmpty())
    }

    @Test
    fun insertTest() {
        val before = userNumber()
        userDao.insert(dummyUser())
        val after = userNumber()
        TestCase.assertTrue(before + 1 <= after)
    }

    @Test
    fun `find lol`() {
        userDao.insert(User(Random.nextInt(), "Lolita"))
        val lols = userDao.getAllWhere("login like 'Lol%'")

        assertTrue(
            lols.asSequence()
                .map { it.login }
                .any { it.startsWith("Lol") }
        )
    }

    fun userNumber(): Long = TODO()
    fun dummyUser(): User = TODO()
}