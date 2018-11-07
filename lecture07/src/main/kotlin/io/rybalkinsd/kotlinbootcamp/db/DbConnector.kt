package io.rybalkinsd.kotlinbootcamp.db

import io.rybalkinsd.kotlinbootcamp.util.logger
import org.jetbrains.exposed.sql.Database


object DbConnector {
    private val log = logger()

    private val host = "54.224.37.210"
    private val port = 5432
    private val dbName = "chatdb_atom49"
    private val user = "atom49"
    private val password = "atom49"

    init {
        Database.connect(
            url = "jdbc:postgresql://$host:$port/$dbName",
            driver = "org.postgresql.Driver",
            user = user,
            password = password
        )

        log.info("Success. DbConnector init.")
    }
}