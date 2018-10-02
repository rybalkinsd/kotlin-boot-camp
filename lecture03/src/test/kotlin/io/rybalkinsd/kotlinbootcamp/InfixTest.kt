package io.rybalkinsd.kotlinbootcamp

import junit.framework.TestCase.assertEquals
import org.junit.Test

class InfixTest {

    @Test
    fun `old multiply`() {
        42.let {  }
        assertEquals(8, 2.multiply( 2).multiply( 2))
    }

    @Test
    fun `infix multiply`() {
        assertEquals(8, 2 multiply 2 multiply 2)
    }
}
