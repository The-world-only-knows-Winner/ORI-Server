package com.onlywin.ori.domain.auth.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash
class AuthCodeEntity(

    @Id
    val id: String,

    val code: String,

    val verified: Boolean,

    @TimeToLive
    var ttl: Long
)
