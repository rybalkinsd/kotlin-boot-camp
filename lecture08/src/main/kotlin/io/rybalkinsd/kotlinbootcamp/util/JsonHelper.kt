package io.rybalkinsd.kotlinbootcamp.util

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


internal object JsonHelper {
    val mapper = ObjectMapper().registerKotlinModule()

    fun toJson(data: Any): String = mapper.writeValueAsString(data)

    inline fun <reified T: Any> fromJson(json: String): T =
        mapper.readValue(json)

    fun getJsonNode(json: String): JsonNode = fromJson(json)
}

fun Any.toJson() = JsonHelper.toJson(this)
