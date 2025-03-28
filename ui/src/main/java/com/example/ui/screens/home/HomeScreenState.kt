package com.example.ui.screens.home

import com.example.domain.model.CourseEntity

data class HomeScreenState(
    val isLoading: Boolean = false,
    var courses: List<CourseEntity> = emptyList(),
    var isSorted: Boolean = false
)