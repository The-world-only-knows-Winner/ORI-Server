package com.onlywin.ori.common.security.jwt

import com.onlywin.ori.domain.auth.dto.response.TokenResponse
import com.onlywin.ori.domain.auth.persistence.RefreshTokenEntity
import com.onlywin.ori.domain.auth.persistence.RefreshTokenRepository
import com.onlywin.ori.domain.auth.spi.JwtPort
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Component
class JwtTokenAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
) : JwtPort {

    override fun generateTokens(id: UUID): TokenResponse {
        val accessToken = generateAccessToken(id)
        val refreshToken = generateRefreshToken(id)

        return TokenResponse(
            accessToken = accessToken,
            accessExpiresAt = LocalDateTime.now().plusSeconds(jwtProperties.accessExp.toLong()),
            refreshToken = refreshToken,
            refreshExpiresAt = LocalDateTime.now().plusSeconds(jwtProperties.refreshExp.toLong()),
        )
    }

    private fun generateAccessToken(id: UUID): String {
        return generateToken(TokenType.ACCESS, id, jwtProperties.accessExp)
    }

    private fun generateRefreshToken(id: UUID): String {
        val token = generateToken(TokenType.REFRESH, id, jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshTokenEntity(
                id = id,
                token = token,
                ttl = jwtProperties.refreshExp.toLong(),
            ),
        )
        return token
    }

    private fun generateToken(type: TokenType, id: UUID, exp: Int): String {
        return Jwts.builder()
            .setSubject(id.toString())
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + (exp * 1000)))
            .claim("type", type.name)
            .compact()
    }
}
