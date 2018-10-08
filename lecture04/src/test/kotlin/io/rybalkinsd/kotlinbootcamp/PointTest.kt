package io.rybalkinsd.kotlinbootcamp

import junit.framework.TestCase.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class PointTest {

    @Test
    fun sum() {
        val sum = Point(1, 1) + Point(4, 9)
        assertTrue(sum.x == 5)
        assertTrue(sum.y == 10)
    }

    @Test
    fun `sum with equals`() {
        assertTrue(Point(5, 10) == Point(1, 1) + Point(4, 9))
    }
}
