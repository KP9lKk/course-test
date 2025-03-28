package com.example.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Either
import com.example.domain.model.CourseEntity
import com.example.domain.usecase.course.CourseUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteScreenViewModel(private val courseUseCase: CourseUseCase): ViewModel() {
    private val _favoriteScreenState = MutableStateFlow(FavoriteScreenState())
    val favoriteScreenState = _favoriteScreenState.asStateFlow()
    init {
        viewModelScope.launch {
            courseUseCase.getAlLFavoriteCourses().collect{ result ->
                when(result){
                    is Either.Right -> {
                        _favoriteScreenState.update { it.copy(courses = result.value) }
                    }
                    is Either.Left -> {

                    }
                }
            }
        }
    }
    fun moveToFavorite(course: CourseEntity){

        viewModelScope.launch {
            val result = courseUseCase.moveCourseToFavorite(course.id).collect{
                if(course.hasLike){
                    _favoriteScreenState.update { it.copy(courses = _favoriteScreenState.value.courses.toMutableList().apply {
                        this.remove(course)
                    }) }
                }
            }
        }
    }
}