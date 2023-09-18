package com.onlywin.ori.common.redis

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@EnableRedisRepositories
@Configuration
class RedisConfig(
    private val redisProperties: RedisProperties,
) {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val configuration = RedisStandaloneConfiguration(redisProperties.host, redisProperties.port)

        if (redisProperties.password.isNotBlank()) {
            configuration.setPassword(redisProperties.password)
        }

        return LettuceConnectionFactory(configuration)
    }
}
