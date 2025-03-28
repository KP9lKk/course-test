package com.example.domain.usecase.course

import com.example.data.command.AddFavoriteCourseCommand
import com.example.data.repository.course.CourseRepository
import com.example.domain.common.Either
import com.example.domain.exception.UseCaseException
import com.example.domain.fromCourseDataToCourse
import com.example.domain.model.CourseEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CourseUseCaseImpl(private val repository: CourseRepository): CourseUseCase {
    override suspend fun getAlLCourses(): Flow<Either<UseCaseException, List<CourseEntity>>> = flow {
        return@flow try {
            val result = repository.getAllCourses()
            emit(Either.Right(result.map { fromCourseDataToCourse(it)}))
        }catch(e: Exception) {
            emit(Either.Left(UseCaseException.DEFAULT))
        }
    }

    override suspend fun getAlLFavoriteCourses(): Flow<Either<UseCaseException, List<CourseEntity>>> = flow {
        return@flow try {
            val result = repository.getFavoriteCourses()
            emit(Either.Right(result.map { fromCourseDataToCourse(it)}))
        }catch(e: Exception) {
            emit(Either.Left(UseCaseException.DEFAULT))
        }
    }

    override suspend fun moveCourseToFavorite(courseId: Int): Flow<Either<UseCaseException, Boolean>> =  flow {
        return@flow try {
            val result = repository.addFavoriteCourse(AddFavoriteCourseCommand(courseId))
            if(result) emit(Either.Right(true)) else emit(Either.Left(UseCaseException.DEFAULT))
        }catch(e: Exception) {
            emit(Either.Left(UseCaseException.DEFAULT))
        }
    }


}