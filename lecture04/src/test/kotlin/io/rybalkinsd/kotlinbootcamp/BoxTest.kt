package io.rybalkinsd.kotlinbootcamp

import org.junit.Test

class BoxTest {
    @Test
    fun `box creation`() {
        val intBox: Box<Int?> = Box(42)
        val nDoubleBox: Box<Double?> = Box(null)
        val doubleBox = Box(4.0)
        // : List<Box<out Number?>>
        val boxedList = listOf(intBox, doubleBox, nDoubleBox)
    }

    @Test
    fun inboxing() {
        val a = null
        val b: Any? = null
        val c = 42

        val rawList = listOf(a, b, c)
        val x = rawList.inbox().also {
            println(it)
        }
    }
}
