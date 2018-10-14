package io.rybalkinsd.kotlinbootcamp

import org.junit.Test

class ApplyTest {

    @Test
    fun `using apply to construct our object`() {
        User(24601).apply {
            lastName = "J"
        }
    }
}