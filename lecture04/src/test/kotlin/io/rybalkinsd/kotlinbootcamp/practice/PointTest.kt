package io.rybalkinsd.kotlinbootcamp.practice

import junit.framework.TestCase.assertTrue
import org.junit.Test

class PointTest {

    @Test
    fun sum() {
        assertTrue(Point(5, 10) == Point(1, 1 ) + Point(4, 9))
    }
}
