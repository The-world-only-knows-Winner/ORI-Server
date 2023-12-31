package com.onlywin.ori.domain.auth.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.UUID

@RedisHash
class RefreshTokenEntity(

    @Id
    val id: UUID,

    @Indexed
    val token: String,

    @TimeToLive
    var ttl: Long,
)
