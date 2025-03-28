package com.example.data.remote.network.request

import kotlinx.serialization.Serializable

@Serializable
data class UpdateCourseLikeRequest(
    val courseId: Int
)