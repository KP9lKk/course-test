package com.example.ui.screens.auth

data class LoginScreenState(
    var email: String = "test@test.ru",
    var password: String = "123",
    var buttonIsEnable: Boolean = false
)