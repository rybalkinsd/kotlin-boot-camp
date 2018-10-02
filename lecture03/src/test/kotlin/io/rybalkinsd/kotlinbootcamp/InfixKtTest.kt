package io.rybalkinsd.kotlinbootcamp

import io.rybalkinsd.kotlinbootcamp.multiply
import junit.framework.TestCase.assertEquals
import org.junit.Test

class InfixKtTest {

    @Test
    fun `old multiply`() {
        assertEquals(8, 2.multiply( 2).multiply( 2))
    }

    @Test
    fun `infix multiply`() {
        assertEquals(8, 2 multiply 2 multiply 2)
    }
}
