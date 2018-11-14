package io.rybalkinsd.kotlinbootcamp.model

import io.rybalkinsd.kotlinbootcamp.dao.Users
import org.jetbrains.exposed.sql.ResultRow

internal fun ResultRow.toUser() = User(this[Users.id], this[Users.login])