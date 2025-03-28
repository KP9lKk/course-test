package com.example.data.remote.network.dto

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class CourseDto(
    val id: Int,
    val title:String,
    val text: String,
    val price: Float,
    val rate: Float,
    val startDate: LocalDate,
    var hasLike: Boolean,
    val publishDate: LocalDate
)