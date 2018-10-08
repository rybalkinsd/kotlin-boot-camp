package io.rybalkinsd.kotlinbootcamp

import org.junit.Test

class ExceptionHandlingTest {

    @Test
    fun `try with number format exception`() {
        try {
            val number = "404e1".toInt().also {
                println(it)
            }
        } catch (e: Exception) {
            println("Catch block")
            e.printStackTrace()
        } finally {
            println("Optional finally block")
        }
    }

    @Test
    fun `try with number format exception # multiple catch`() {
        try {
            val number = "404e1".toInt().also {
                println(it)
            }
        } catch (e: NumberFormatException) {
            println("NumberFormatException catch")
            e.printStackTrace()
        } catch (e: Exception) {
            println("Exception catch")
            e.printStackTrace()
        }
    }

    @Test
    fun `try # expression`() {
        val number: Int? = try {
            "404e1".toInt()
        } catch (e: NumberFormatException) {
            println("NumberFormatException catch")
            e.printStackTrace()
            null
        }
    }

    @Test(expected = Exception::class)
    fun `elvis throw`() {
        val number = "404e1".toIntOrNull() ?: throw Exception("Oops")
    }
}