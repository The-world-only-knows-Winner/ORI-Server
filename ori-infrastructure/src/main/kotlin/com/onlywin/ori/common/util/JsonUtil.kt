package com.onlywin.ori.common.util

import com.fasterxml.jackson.databind.JsonNode

fun JsonNode.findValueByFieldName(fieldName: String): String {
    return try {
        this.findValue(fieldName).asText()
    } catch (e: NullPointerException) {
        ""
    }
}
