package io.rybalkinsd.kotlinbootcamp.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * logger
 */
inline fun <reified T : Any> T.logger(): Logger = LoggerFactory.getLogger(
        if (T::class.isCompanion) T::class.java.enclosingClass
        else T::class.java
)
