package com.example.domain.model

import kotlinx.datetime.LocalDate


data class CourseEntity(
    val id: Int,
    val title:String,
    val text: String,
    val price: Float,
    val rate: Float,
    val startDate: LocalDate,
    var hasLike: Boolean = false,
    val publishDate: LocalDate
)