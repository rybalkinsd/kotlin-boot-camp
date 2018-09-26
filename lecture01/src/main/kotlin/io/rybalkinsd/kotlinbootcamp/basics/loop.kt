package io.rybalkinsd.kotlinbootcamp.basics

fun forLoop() {
    for (e in listOf(1, 2, 3, 4, 5)) {
        println(e)
    }

    for (e in 6..10) {
        println(e)
    }
}

fun forLoopFunctional() {
    listOf(1, 2, 3, 4, 5).forEach { println(it) }

    (6..10).forEach { println(it) }
}

fun repeatLoop() {
    repeat(10) {
        println(it)
    }
}
