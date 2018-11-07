package io.rybalkinsd.kotlinbootcamp.model

import org.joda.time.DateTime

data class User(val id: Int, val login: String)

data class Message(val id: Int, val user: User, val timestamp: DateTime, val value: String)
