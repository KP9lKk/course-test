package com.example.domain.validator

interface Validation {
    fun <T> validate(value: T): Boolean
}