package com.example.domain.usecase.auth

import com.example.domain.command.LoginCommand

interface AuthUseCase {
    suspend fun login(loginCommand: LoginCommand): Boolean
}