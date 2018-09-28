package io.rybalkinsd.kotlinbootcamp.geometry

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class PointPointCollisionTest {
    @Test
    fun `equal points`() {
        val point1 = Point(100, 100)
        val point2 = Point(100, 100)
        assertEquals(point1, point2)
    }

    @Test
    fun `point self collide`() {
        val point = Point(100, 100)
        assertTrue(point.isColliding(point))
    }

    @Test
    fun `equal points collide`() {
        val point1 = Point(100, 100)
        val point2 = Point(100, 100)
        assertTrue(point1.isColliding(point2))
    }

    @Test
    fun `points does not collide`() {
        val point1 = Point(200, 100)
        val point2 = Point(100, 100)
        assertFalse(point1.isColliding(point2))
    }

    @Test
    fun `points does not collide 2`() {
        val point1 = Point(100, 100)
        val point2 = Point(200, 100)
        assertFalse(point1.isColliding(point2))
    }

    @Test
    fun `points does not collide 3`() {
        val point1 = Point(100, 100)
        val point2 = Point(200, 200)
        assertFalse(point1.isColliding(point2))
    }
}
