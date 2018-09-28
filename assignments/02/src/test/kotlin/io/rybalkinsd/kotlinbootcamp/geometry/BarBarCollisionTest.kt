package io.rybalkinsd.kotlinbootcamp.geometry

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class BarBarCollisionTest {
    @Test
    fun `equal bars`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(0, 0, 100, 100)
        assertEquals(bar1, bar2)
    }

    @Test
    fun `bar self collide`() {
        val bar = Bar(0, 0, 100, 100)
        assertTrue(bar.isColliding(bar))
    }

    @Test
    fun `bar is not oriented`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(100, 100, 0, 0)
        assertEquals(bar1, bar2)
    }

    @Test
    fun `bar is not oriented 2`() {
        val bar1 = Bar(0, 100, 100, 0)
        val bar2 = Bar(100, 100, 0, 0)
        assertEquals(bar1, bar2)
    }

    @Test
    fun `bar is not oriented 3`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(100, 0, 0, 100)
        assertEquals(bar1, bar2)
    }

    @Test
    fun `equal bars collide`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `equal bars collide 2`() {
        val bar1 = Bar(0, 100, 100, 0)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `equal bars collide 3`() {
        val bar1 = Bar(100, 0, 0, 100)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(50, 0, 150, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars 2`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(0, 50, 100, 150)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars 3`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(50, 50, 150, 150)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars 4`() {
        val bar1 = Bar(50, 0, 150, 100)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars 5`() {
        val bar1 = Bar(0, 50, 100, 150)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `intersecting bars 6`() {
        val bar1 = Bar(50, 50, 150, 150)
        val bar2 = Bar(0, 0, 100, 100)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `bar intersects bar by border`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(0, 100, 100, 200)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `bar intersects bar by corner`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(100, 100, 200, 200)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `bar includes bar`() {
        val bar1 = Bar(0, 0, 200, 200)
        val bar2 = Bar(50, 50, 150, 150)
        assertTrue(bar1.isColliding(bar2))
        assertTrue(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(0, 150, 100, 250)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar 2`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(150, 0, 250, 100)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar 3`() {
        val bar1 = Bar(0, 0, 100, 100)
        val bar2 = Bar(150, 150, 200, 200)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar 4`() {
        val bar1 = Bar(0, 150, 100, 250)
        val bar2 = Bar(0, 0, 100, 100)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar 5`() {
        val bar1 = Bar(150, 0, 250, 100)
        val bar2 = Bar(0, 0, 100, 100)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }

    @Test
    fun `bar does not intersect bar 6`() {
        val bar1 = Bar(150, 150, 200, 200)
        val bar2 = Bar(0, 0, 100, 100)
        assertFalse(bar1.isColliding(bar2))
        assertFalse(bar2.isColliding(bar1))
    }
}
