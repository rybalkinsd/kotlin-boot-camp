package io.rybalkinsd.kotlinbootcamp.example

import io.rybalkinsd.kotlinbootcamp.util.logger
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

class SingletonBean(var data: String?) {
    @Autowired
    private lateinit var counterService: CounterService

    @PostConstruct
    fun init() {
        logger().info("{} created", this::class.simpleName)
        counterService.register(this)
    }

    override fun toString() = data.toString()
}

open class PrototypeBean(var data: String?) {
    @Autowired
    private lateinit var counterService: CounterService

    @PostConstruct
    fun init() {
        logger().info("{} created", this::class.simpleName)
        counterService.register(this)
    }

    override fun toString() = data.toString()
}

open class RequestBean(var data: String?) {
    @Autowired
    private lateinit var counterService: CounterService

    @PostConstruct
    fun init() {
        logger().info("{} created", this::class.simpleName)
        counterService.register(this)
    }

    override fun toString() = data.toString()
}