package io.rybalkinsd.kotlinbootcamp

import org.junit.Test

class ComparatorTest {

    @Test
    fun `case insensitive comparator`() {
        listOf("A", "b", "X", "C", "c", "d", "abc")
            .sortedWith(CaseInsensitiveComparator)
            .also {
                println(it)
            }
    }
}