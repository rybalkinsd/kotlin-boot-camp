package io.rybalkinsd.kotlinbootcamp.point

import io.rybalkinsd.kotlinbootcamp.extension.isZero
import io.rybalkinsd.kotlinbootcamp.extension.symmetrical
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue

import org.junit.Test

class PointsTest {

    @Test
    fun `point 1`() {
        val p = Point1(100, 200)
        println(p.toString())
    }

    @Test
    fun `point 2`() {
        val p = Point2(100, 200)
        println(p.toString())
    }

    @Test
    fun `point 3`() {
        val p = Point3(100, 200)
        println(p.toString())
    }

    @Test
    fun `point - our best option`() {
        val p = Point(100, 200)
        println(p.toString())
    }

    @Test
    fun `point # izZero extension`() {
        assertTrue(Point(0, 0).isZero())

        assertFalse(Point(0, 100).isZero())
    }

    @Test
    fun `point # count non-zero points in list`() {
        assertEquals(
            2,
            listOf(Point(1, 2), Point(0, 0), Point(3, 5))
                .filter { !it.isZero() }
                .count()
        )
    }

    @Test
    fun `point # symmetrical extension`() {
        assertTrue(Point(0, 0).symmetrical() == Point(0, 0))
        assertTrue(Point(0, 100).symmetrical() == Point(0, -100))
    }
}
