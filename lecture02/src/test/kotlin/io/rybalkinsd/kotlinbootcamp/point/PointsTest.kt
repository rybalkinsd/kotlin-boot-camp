package io.rybalkinsd.kotlinbootcamp.point

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

}