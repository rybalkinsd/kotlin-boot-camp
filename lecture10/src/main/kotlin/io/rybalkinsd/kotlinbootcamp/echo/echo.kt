package io.rybalkinsd.kotlinbootcamp.echo

import io.rybalkinsd.kotlinbootcamp.billing.BillingApp
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@RequestMapping("/echo")
class Controller {
    @RequestMapping("")
    @ResponseBody
    fun echo(): String {
        return User().apply {
            id = 42
            firstName = "Alice"
            secondName = "Bob"
            account = Account(42, 42)
        }.toString()
    }
}

@SpringBootApplication
class EchoApp

fun main(args: Array<String>) {
    runApplication<BillingApp>(*args) {
        addInitializers(beans {
            bean<Controller>()
        })
    }
}
