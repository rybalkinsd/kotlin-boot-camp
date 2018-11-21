package io.rybalkinsd.kotlinbootcamp.billing

class VolatileExample {

    // in jvm
    // public volatile Boolean running;
    @Volatile
    var running = true

    fun test() {
        Thread {
            var counter = 0
            while (running) {
                counter++
            }
            println("Thread 1 finished. Counted up to $counter")
        }.start()

        Thread {
            // Sleep for a bit so that thread 1 has a chance to start
            Thread.sleep(100)
            println("Thread 2 finishing")
            running = false
        }.start()
    }

}

fun main(args: Array<String>) {
    VolatileExample().test()
}
