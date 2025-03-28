package com.example.domain

import com.example.data.model.Course
import com.example.domain.model.CourseEntity

fun fromCourseDataToCourse(course: Course): CourseEntity{
    return CourseEntity(
        id = course.id,
        rate = course.rate,
        text = course.text,
        title = course.title,
        price = course.price,
        hasLike = course.hasLike,
        startDate = course.startDate,
        publishDate = course.publishDate,
    )
}