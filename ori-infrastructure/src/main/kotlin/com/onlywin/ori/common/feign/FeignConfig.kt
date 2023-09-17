package com.onlywin.ori.common.feign

import com.onlywin.ori.BASE_PACKAGE
import com.onlywin.ori.common.feign.exception.FeignBadRequestException
import com.onlywin.ori.common.feign.exception.FeignExpiredTokenException
import com.onlywin.ori.common.feign.exception.FeignForbiddenException
import com.onlywin.ori.common.feign.exception.FeignInternalServerErrorException
import com.onlywin.ori.common.feign.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = [BASE_PACKAGE])
@ImportAutoConfiguration(FeignAutoConfiguration::class)
@Configuration
class FeignConfig {

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class])
    fun commonFeignErrorDecoder(): FeignClientErrorDecoder = FeignClientErrorDecoder()
}

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignExpiredTokenException
                else -> throw FeignInternalServerErrorException
            }
        }
        return FeignException.errorStatus(methodKey, response)
    }
}
