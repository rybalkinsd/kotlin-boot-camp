package io.rybalkinsd.kotlinbootcamp

import org.junit.Ignore
import org.junit.Test

@Ignore
class CastingTest {

    val value: Any = 42
    val nValue: Any? = null

    @Test
    fun `cast 1 test`() {
        println(cast1(value))
        println(cast1(nValue))
    }

    @Test
    fun `cast 2 test`() {
        println(cast2(value))
        println(cast2(nValue))

    }

    @Test
    fun `cast 3 test`() {
        println(cast3(value))
        println(cast3(nValue))
    }
}