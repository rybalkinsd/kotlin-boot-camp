package io.rybalkinsd.kotlinbootcamp

import junit.framework.TestCase.assertEquals
import org.junit.Test

class EchoKtTest {

    @Test
    fun `test echo`() {
        assertEquals("hello", echo("hello"))
    }
}