package com.example.data.repository.course

import com.example.data.command.AddFavoriteCourseCommand
import com.example.data.model.Course
import com.example.data.remote.network.CourseApi
import com.example.data.remote.network.dto.toCourse
import com.example.data.remote.network.request.UpdateCourseLikeRequest

class CourseRepositoryImpl(private val courseApi: CourseApi): CourseRepository {
    override suspend fun getAllCourses(): List<Course> {
       return courseApi.getAllCourses().map { it.toCourse() }
    }

    override suspend fun getFavoriteCourses(): List<Course> {
        return courseApi.getAllCourses().filter { it.hasLike }.map { it.toCourse() }
    }

    override suspend fun addFavoriteCourse(addFavoriteCourseCommand: AddFavoriteCourseCommand): Boolean {
        return courseApi.updateCourseLike(UpdateCourseLikeRequest(addFavoriteCourseCommand.courseId))
    }
}