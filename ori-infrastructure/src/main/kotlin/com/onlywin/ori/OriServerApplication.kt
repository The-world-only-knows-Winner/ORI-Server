package com.onlywin.ori

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

internal const val BASE_PACKAGE = "com.onlywin.ori"

@ConfigurationPropertiesScan
@SpringBootApplication
class OriServerApplication

fun main(args: Array<String>) {
    runApplication<OriServerApplication>(*args)
}
