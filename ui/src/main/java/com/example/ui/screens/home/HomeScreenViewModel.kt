package com.example.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Either
import com.example.domain.model.CourseEntity
import com.example.domain.usecase.course.CourseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val courseUseCase: CourseUseCase): ViewModel() {
    private val _homeScreenState = MutableStateFlow(HomeScreenState())
    val homeScreenState = _homeScreenState.asStateFlow()

    fun getCourse(){
        viewModelScope.launch {
            courseUseCase.getAlLCourses().collect{ result ->
                when(result){
                    is Either.Right -> {
                        _homeScreenState.update { it.copy(courses = result.value) }
                    }
                    is Either.Left -> {

                    }
                }
            }
        }
    }

    fun moveToFavorite(course: CourseEntity){
        viewModelScope.launch {
            courseUseCase.moveCourseToFavorite(course.id).collect{}
        }
    }
    fun sortedByPublishDate(){
        _homeScreenState.update {
            it.copy(courses = it.courses.sortedBy { it.publishDate })
        }
    }
}