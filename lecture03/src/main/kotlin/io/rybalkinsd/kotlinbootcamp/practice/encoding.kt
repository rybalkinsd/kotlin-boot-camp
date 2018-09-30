package io.rybalkinsd.kotlinbootcamp.practice


/**
 * Military alphabet
 */
val alphabet = setOf("alpha", "bravo", "charlie")

/**
 * A mapping for english characters to military alphabet.
 * [ a -> alpha, b -> bravo, ...]
 */
val association: Map<Char, String> = TODO()

/**
 * Extension function for String which encode it according to `association` mapping
 *
 * @return encoded string
 *
 * Example:
 * "abc".encode() == "alphabravocharlie"
 *
 */
fun String.encode(): String = TODO()

/**
 * A reversed mapping for association
 * [ alpha -> a, bravo -> b, ...]
 */
val reversedAssociation: Map<String, Char> = TODO()


/**
 * Extension function for String which decode it according to `reversedAssociation` mapping
 *
 * @return encoded string or null if it is impossible to decode
 *
 * Example:
 * "alphabravocharlie".encode() == "abc"
 * "charliee".decode() == null
 *
 */
fun String.decode(): String? = TODO()




