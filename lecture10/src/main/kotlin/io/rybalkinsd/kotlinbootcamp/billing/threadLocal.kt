package io.rybalkinsd.kotlinbootcamp.billing

import kotlin.random.Random

val sharedRunnableInstance = object : Runnable {
    // This container contains different references for different threads
    private val threadLocal = ThreadLocal<Int>()

    override fun run() {
        threadLocal.set(Random.nextInt() * 100)
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        println(threadLocal.get())
    }
}

fun main(args: Array<String>) {
    val thread1 = Thread(sharedRunnableInstance)
    val thread2 = Thread(sharedRunnableInstance)

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}