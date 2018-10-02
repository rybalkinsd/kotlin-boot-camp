package io.rybalkinsd.kotlinbootcamp.practice

import junit.framework.TestCase.assertTrue
import org.junit.Test

class DataAnalysisTest {

    @Test
    fun `check avg age`() {
        assertTrue(avgAge.isNotEmpty())
    }

    @Test
    fun `check grouped profiles`() {
        assertTrue(groupedProfiles.isNotEmpty())
    }
}
