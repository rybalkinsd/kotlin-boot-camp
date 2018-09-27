package io.rybalkinsd.kotlinbootcamp.basics

fun countDigits(string: String): String {
    return when (string.toInt()) {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> "1 digit"
        in 10..99 -> "2 digits"
        else -> "many digits"
    }
}

fun countDigitsSimplified(string: String) = when (string.toInt()) {
    in 0..9 -> "1 digit"
    in 10..99 -> "2 digits"
    else -> "many digits"
}
