package io.rybalkinsd.kotlinbootcamp.network

data class Message(val topic: Topic, val data: String)

data class User(val id: Long, val name: String)
