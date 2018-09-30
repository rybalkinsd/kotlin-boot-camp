package io.rybalkinsd.kotlinbootcamp.practice

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class EncodingTest {

    @Test
    fun association() {
        assertTrue(association.containsKey('a'))
        assertTrue(association.containsKey('b'))
        assertTrue(association.containsKey('c'))
    }

    @Test
    fun `encode # abc`() {
        assertEquals("alphabravocharlie", "abc".encode())
    }

    @Test
    fun `encode # kotlin`() {
        assertEquals("todo", "kotlin".encode())
    }

    @Test
    fun `encode # ab 123c`() {
        assertEquals("alphabravo 123charlie", "ab 123c".encode())
    }

    @Test
    fun `reverse association`() {
        assertTrue(reversedAssociation.containsKey("alpha"))
        assertTrue(reversedAssociation.containsKey("bravo"))
        assertTrue(reversedAssociation.containsKey("charlie"))
    }


    @Test
    fun `decode # abc`() {
        assertEquals("abc", "alphabravocharlie".decode())
    }


    @Test
    fun `decode # ab 123c`() {
        assertEquals("ab 123c", "alphabravo 123charlie".decode())
    }

    @Test
    fun `decode # charliee`() {
        assertNull("charliee".decode())
    }

    @Test
    fun `decode # charli 1`() {
        assertNull("charli 1".decode())
    }

}
