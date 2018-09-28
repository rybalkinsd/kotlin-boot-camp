package io.rybalkinsd.kotlinbootcamp.geometry

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class PointBarCollisionTest {
    @Test
    fun `point inside bar`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(50, 50)
        assertTrue(bar.isColliding(point))
        assertTrue(point.isColliding(bar))
    }

    @Test
    fun `point on corner of bar`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(0, 0)
        assertTrue(bar.isColliding(point))
        assertTrue(point.isColliding(bar))
    }

    @Test
    fun `point on border of bar`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(0, 50)
        assertTrue(bar.isColliding(point))
        assertTrue(point.isColliding(bar))
    }

    @Test
    fun `point outside of bar`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(0, 150)
        assertFalse(bar.isColliding(point))
        assertFalse(point.isColliding(bar))
    }

    @Test
    fun `point outside of bar 2`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(150, 0)
        assertFalse(bar.isColliding(point))
        assertFalse(point.isColliding(bar))
    }

    @Test
    fun `point outside of bar 3`() {
        val bar = Bar(0, 0, 100, 100)
        val point = Point(150, 150)
        assertFalse(bar.isColliding(point))
        assertFalse(point.isColliding(bar))
    }
}
