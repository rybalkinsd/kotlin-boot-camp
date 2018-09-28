package io.rybalkinsd.kotlinbootcamp.geometry

interface Collider {
    fun isColliding(other: Collider): Boolean
}

class Point(x: Int, y: Int) : Collider {
    override fun isColliding(other: Collider): Boolean {
        TODO("not implemented")
    }
}

class Bar(firstCornerX: Int, firstCornerY: Int, secondCornerX: Int, secondCornerY: Int) : Collider {
    override fun isColliding(other: Collider): Boolean {
        TODO("not implemented")
    }
}