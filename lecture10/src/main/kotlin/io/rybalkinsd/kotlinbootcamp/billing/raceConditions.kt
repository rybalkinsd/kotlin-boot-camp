package io.rybalkinsd.kotlinbootcamp.billing

val action = {
    println(Thread.currentThread().name)
}

fun main(args: Array<String>) {
    for (i in 0..9) {
        Thread {
            action()
        }.start()
    }
}