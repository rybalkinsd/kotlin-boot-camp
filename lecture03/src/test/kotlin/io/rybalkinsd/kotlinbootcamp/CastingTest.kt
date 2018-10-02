package io.rybalkinsd.kotlinbootcamp

import org.junit.Test

class CastingTest {

    val value: Any = 42
    val nullValue: Any? = null
    val incompatibleValue: Any = 4.2

    @Test
    fun `cast 1 # general value`() {
        println(cast1(value))
    }

    @Test(expected = TypeCastException::class)
    fun `cast 1 # null value`() {
        println(cast1(nullValue))
    }

    @Test(expected = ClassCastException::class)
    fun `cast 1 # incompatible type`() {
        println(cast1(incompatibleValue))
    }

    @Test
    fun `cast 2 # general value`() {
        println(cast2(value))
    }

    @Test
    fun `cast 2 # null value`() {
        println(cast2(nullValue))
    }

    @Test(expected = ClassCastException::class)
    fun `cast 2 # incompatible type`() {
        println(cast2(incompatibleValue))
    }

    @Test
    fun `cast 3 # general value`() {
        println(cast3(value))
    }

    @Test
    fun `cast 3 # null value`() {
        println(cast3(nullValue))
    }

    @Test
    fun `cast 3 # incompatible type`() {
        println(cast3(incompatibleValue))
    }
}
