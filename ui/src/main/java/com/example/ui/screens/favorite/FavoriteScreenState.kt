package com.example.ui.screens.favorite

import com.example.domain.model.CourseEntity

data class FavoriteScreenState(
    val isLoading: Boolean = false,
    var courses: List<CourseEntity> = emptyList(),
)