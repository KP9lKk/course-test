package com.example.data.model

import kotlinx.datetime.LocalDate

data class Course (
    val id: Int,
    val title:String,
    val text: String,
    val price: Float,
    val rate: Float,
    val startDate: LocalDate,
    var hasLike: Boolean,
    val publishDate: LocalDate
)