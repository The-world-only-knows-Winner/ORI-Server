package com.onlywin.ori.domain.user.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.user.dto.request.UpdateUserInfoRequest
import com.onlywin.ori.domain.user.exception.UserNotFoundException
import com.onlywin.ori.domain.user.spi.CommandUserPort
import com.onlywin.ori.domain.user.spi.QueryUserPort

@UseCase
class UpdateUserInfoUseCase(
    private val securityPort: SecurityPort,
    private val commandUserPort: CommandUserPort,
    private val queryUserPort: QueryUserPort,
) {

    fun execute(request: UpdateUserInfoRequest) {
        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        commandUserPort.saveUser(
            user.updateUserInfo(
                name = request.name,
                birthday = request.birthday,
            ),
        )
    }
}
