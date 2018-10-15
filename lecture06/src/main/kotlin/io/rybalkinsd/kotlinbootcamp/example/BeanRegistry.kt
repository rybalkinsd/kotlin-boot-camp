package io.rybalkinsd.kotlinbootcamp.example

import io.rybalkinsd.kotlinbootcamp.util.logger
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

interface BeanRegistryService {
    fun register(bean: Any)
    fun size(): Long
}

@Service
class CounterService : BeanRegistryService {
    val counter: AtomicLong = AtomicLong(0)
    override fun size() = counter.get()

    override fun register(bean: Any) {
        counter.incrementAndGet()
        logger().info(bean.toString() + " registered")
    }
}