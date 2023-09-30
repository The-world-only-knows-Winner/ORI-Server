package com.onlywin.ori.domain.user.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.user.dto.response.QueryMyInfoResponse
import com.onlywin.ori.domain.user.exception.UserNotFoundException
import com.onlywin.ori.domain.user.spi.QueryUserPort

@UseCase
class QueryMyInfoUseCase(
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort,
) {

    fun execute(): QueryMyInfoResponse {
        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        return QueryMyInfoResponse(
            name = user.name,
            birthday = user.birthday,
        )
    }
}
