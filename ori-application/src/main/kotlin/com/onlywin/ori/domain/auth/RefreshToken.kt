package com.onlywin.ori.domain.auth

import com.onlywin.ori.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class RefreshToken(
    val id: UUID,
    val token: String,
    val ttl: Long
)
