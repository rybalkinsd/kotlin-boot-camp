package io.rybalkinsd.kotlinbootcamp.game


import io.rybalkinsd.kotlinbootcamp.util.logger
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.LockSupport

class Ticker {
    private val tickables = ConcurrentSkipListSet<Tickable>()
    var tickNumber: Long = 0

    fun gameLoop() {
        while (!Thread.currentThread().isInterrupted) {
            val started = System.currentTimeMillis()
            act(FRAME_TIME)
            val elapsed = System.currentTimeMillis() - started
            if (elapsed < FRAME_TIME) {
                log.info("All tick finish at {} ms", elapsed)
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(FRAME_TIME - elapsed))
            } else {
                log.warn("tick lag {} ms", elapsed - FRAME_TIME)
            }
            log.info("{}: tick ", tickNumber)
            tickNumber++
        }
    }

    fun registerTickable(tickable: Tickable) {
        tickables.add(tickable)
    }

    fun unregisterTickable(tickable: Tickable) {
        tickables.remove(tickable)
    }

    private fun act(elapsed: Long) {
        tickables.forEach { it.tick(elapsed) }
    }

    companion object {
        private val log = logger()
        private const val FPS = 60
        private const val FRAME_TIME = (1000 / FPS).toLong()
    }
}