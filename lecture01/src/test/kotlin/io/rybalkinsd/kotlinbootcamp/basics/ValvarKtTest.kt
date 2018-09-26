package io.rybalkinsd.kotlinbootcamp.basics

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

class ValvarKtTest {

    @Test
    fun `check number`() {
        assertEquals(42, number)
    }

    @Test
    fun `check list`() {
        assertEquals(listOf(1, 2, 3, 4), list)
    }

    @Test
    fun `check array`() {
        assertTrue(arrayOf(1, 2, 3, 4).contentEquals(array))
    }

    @Test
    fun `check variable modification`() {
        assertEquals("after", modifyVariable())
    }
}
