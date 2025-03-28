package com.example.domain.usecase.course

import com.example.data.command.AddFavoriteCourseCommand
import com.example.domain.common.Either
import com.example.domain.exception.UseCaseException
import com.example.domain.model.CourseEntity
import kotlinx.coroutines.flow.Flow

interface CourseUseCase {
    suspend fun getAlLCourses(): Flow<Either<UseCaseException, List<CourseEntity>>>
    suspend fun getAlLFavoriteCourses(): Flow<Either<UseCaseException, List<CourseEntity>>>
    suspend fun moveCourseToFavorite(courseId: Int): Flow<Either<UseCaseException, Boolean>>
}