package com.example.domain.validator

class EmailValidation: Validation {
    private val pattern  = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+\$"
    override fun <T> validate(value: T): Boolean {
        val email = value as String
        return email.matches(pattern.toRegex())
    }
}