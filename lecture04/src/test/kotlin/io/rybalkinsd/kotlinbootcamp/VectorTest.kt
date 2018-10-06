package io.rybalkinsd.kotlinbootcamp

import junit.framework.TestCase.assertTrue
import org.junit.Ignore
import org.junit.Test

@Ignore
class VectorTest {

    @Test
    fun `abs comparison`() {
        assertTrue(Vector(100, 10) > Vector(50, 2))
        assertTrue(Vector(50, 2) < Vector(100, 10))
    }

    @Test
    fun `equals comparison`() {
        assertTrue(Vector(100, 10) == Vector(50, 2))
    }
}
