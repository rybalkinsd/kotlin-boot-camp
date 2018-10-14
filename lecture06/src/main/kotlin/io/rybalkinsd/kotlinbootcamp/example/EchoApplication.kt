package io.rybalkinsd.kotlinbootcamp.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchoApplication

fun main(args: Array<String>) {
    runApplication<EchoApplication>(*args)
}