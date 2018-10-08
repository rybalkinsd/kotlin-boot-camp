package io.rybalkinsd.kotlinbootcamp

/**
 *
 *          Box
 *         -----
 *  p -->  | T |
 *         -----
 *
 *
 */
data class Box<T>(val value: T)

/**
 *
 *             Box    Box    Box
 *            -----  -----  -----
 * list --> ( | T |, | T |, | T | )
 *            -----  -----  -----
 *          .unbox()
 *
 *
 * list --> (T, T, T)
 *
 */
fun <T> List<Box<out T>>.unbox(): List<T> = map { it.value }

/**
 *
 * list --> (T, T, T)
 *          .inbox()
 *
 *             Box    Box    Box
 *            -----  -----  -----
 * list --> ( | T |, | T |, | T | )
 *            -----  -----  -----
 *
 */
fun <T> List<T>.inbox(): List<Box<T>> = map { Box(it) }

class SafeBox<T : Any>(val value: T)
