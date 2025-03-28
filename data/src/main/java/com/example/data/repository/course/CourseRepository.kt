package com.example.data.repository.course

import com.example.data.command.AddFavoriteCourseCommand
import com.example.data.model.Course
import com.example.data.remote.network.dto.CourseDto

interface CourseRepository {
    suspend fun getAllCourses(): List<Course>
    suspend fun getFavoriteCourses(): List<Course>
    suspend fun addFavoriteCourse(addFavoriteCourseCommand: AddFavoriteCourseCommand): Boolean
}