package com.onlywin.ori.domain.auth.usecase

import com.onlywin.ori.common.annotation.UseCase
import com.onlywin.ori.common.spi.SecurityPort
import com.onlywin.ori.domain.auth.dto.request.ChangePasswordRequest
import com.onlywin.ori.domain.auth.exception.PasswordMisMatchException
import com.onlywin.ori.domain.user.exception.UserNotFoundException
import com.onlywin.ori.domain.user.spi.CommandUserPort
import com.onlywin.ori.domain.user.spi.QueryUserPort

@UseCase
class ChangePasswordUseCase(
    private val securityPort: SecurityPort,
    private val commandUserPort: CommandUserPort,
    private val queryUserPort: QueryUserPort,
) {

    fun execute(request: ChangePasswordRequest) {
        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        checkOldPasswordMatches(
            oldPassword = request.oldPassword,
            encodeOldPassword = user.password,
        )

        val encodeNewPassword = securityPort.encodePassword(request.newPassword)
        commandUserPort.saveUser(user.changePassword(encodeNewPassword))
    }

    private fun checkOldPasswordMatches(oldPassword: String, encodeOldPassword: String) {
        val isOldPasswordMatches = securityPort.passwordMatches(oldPassword, encodeOldPassword)
        if (!isOldPasswordMatches) {
            throw PasswordMisMatchException
        }
    }
}
