package io.rybalkinsd.kotlinbootcamp

import kotlin.math.sign
import kotlin.math.sqrt

open class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

class Vector(x: Int, y: Int) : Point(x, y), Comparable<Vector> {
    private val abs: Double
        get() = sqrt((x * x + y * y).toDouble())

    override fun compareTo(other: Vector): Int = sign(abs - other.abs).toInt()
}
