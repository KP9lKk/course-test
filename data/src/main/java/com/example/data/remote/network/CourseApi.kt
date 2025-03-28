package com.example.data.remote.network

import com.example.data.remote.network.dto.CourseDto
import com.example.data.remote.network.request.UpdateCourseLikeRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface CourseApi {
    @GET("/courses")
    suspend fun getAllCourses(): List<CourseDto>

    @PUT("/courses")
    suspend fun updateCourseLike(@Body courseLikeRequest: UpdateCourseLikeRequest): Boolean
}