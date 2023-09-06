package com.onlywin.ori.common.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
data class JwtProperties(
    val secret: String,
    val header: String,
    val prefix: String,
    val accessExp: Int,
    val refreshExp: Int,
)
