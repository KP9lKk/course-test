package com.example.ui.screens.auth

data class LoginScreenState(
    var email: String = "",
    var password: String = "",
    var buttonIsEnable: Boolean = false
)