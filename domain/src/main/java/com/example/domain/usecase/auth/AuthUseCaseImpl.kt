package com.example.domain.usecase.auth

import com.example.domain.command.LoginCommand
import com.example.domain.validator.EmailValidation

class AuthUseCaseImpl: AuthUseCase {
    override suspend fun login(loginCommand: LoginCommand): Boolean {
        return EmailValidation().validate(loginCommand.email) and loginCommand.password.isNotEmpty()
    }
}