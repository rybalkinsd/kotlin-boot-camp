package io.rybalkinsd.kotlinbootcamp.practice

import org.junit.Ignore
import org.junit.Test

@Ignore
class CollectionsTest {
    @Test
    fun `how to create collections`() {
        println(ArrayList<Int>()) // Java way
        println(listOf(1, 2)) // immutable list
        println(mutableListOf(5, 6)) // mutable list
        println(arrayListOf(3, 4))
        println(mapOf("one" to 1, "two" to "two"))
    }

    @Test
    fun `immutable collections`() {
        val immutableSet = setOf(1, 2)
        println(immutableSet)
        // immutableSet.add() // compile error: you can not add to immutable collection
        // immutableSet.clear() // compile error: you can clear immutable collection

        val mutableSet = mutableSetOf(3, 4)
        mutableSet.add(5)
        println(mutableSet)
    }

    @Test
    fun `types of kotlin IMMUTABLE collections`() {
        val set = setOf(1, 2)
        println(set::class)
        val list = listOf(1, 2)
        println(list::class)
        val map = mapOf(1 to "one", 2 to "two")
        println(map::class)
    }

    @Test
    fun `types of kotlin MUTABLE collections`() {
        val set = mutableSetOf(1, 2)
        println(set::class)
        val list = mutableListOf(1, 2)
        println(list::class)
        val map = mutableMapOf(1 to "one", 2 to "two")
        println(map::class)
    }

    @Test
    fun sequences() {
        // 5 map() and filter() operations will be done
        println(listOf(1, 2, 3, 4, 5)
                .map { n -> n * n }
                .filter { n -> n < 10 }
                .first())
        // only one map() and filter() will be done
        println(listOf(1, 2, 3, 4, 5)
                .asSequence()
                .map { n -> n * n }
                .filter { n -> n < 10 }
                .first())
    }
}
