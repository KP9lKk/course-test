package com.example.data.remote.network.dto

import com.example.data.model.Course

fun CourseDto.toCourse(): Course = Course(id, title, text, price, rate, startDate, hasLike, publishDate)