package io.rybalkinsd.kotlinbootcamp.practice

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class EncodingTest {

    @Test
    fun association() {
        assertTrue(association.containsKey('a'))
        assertTrue(association.containsKey('b'))
        assertTrue(association.containsKey('c'))
    }

    @Test
    fun `encode # abc`() {
        assertEquals("AlfaBravoCharlie", "abc".encode())
    }

    @Test
    fun `encode # kotlin`() {
        assertEquals("KiloOscarTangoLimaIndiaNovember", "kotlin".encode())
    }

    @Test
    fun `encode # ab 123c`() {
        assertEquals("AlfaBravo 123Charlie", "ab 123c".encode())
    }

    @Test
    fun `reverse association`() {
        assertTrue(reversedAssociation.containsKey("Alfa"))
        assertTrue(reversedAssociation.containsKey("Bravo"))
        assertTrue(reversedAssociation.containsKey("Charlie"))
    }

    @Test
    fun `decode # abc`() {
        assertEquals("abc", "AlfaBravoCharlie".decode())
    }

    @Test
    fun `decode # Abc`() {
        assertEquals("Abc", "AlfaBravoCharlie".decode())
    }

    @Test
    fun `decode # AlfaBravo 123Charlie`() {
        assertEquals("ab 123c", "AlfaBravo 123Charlie".decode())
    }

    @Test
    fun `decode # Charliee`() {
        assertNull("Charliee".decode())
    }

    @Test
    fun `decode # Charli 1`() {
        assertNull("Charli 1".decode())
    }
}
