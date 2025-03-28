package com.example.data.remote.network

import com.example.data.remote.network.dto.CourseDto
import com.example.data.remote.network.request.UpdateCourseLikeRequest
import kotlinx.datetime.LocalDate

class CourseApiImpl: CourseApi {
    val coursesRemote = mutableListOf(CourseDto(
        id = 100,
        title = "Java-разработчик с нуля",
        text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
        price = 999f,
        rate = 4.9f,
        startDate = LocalDate.parse("2024-05-22"),
        hasLike = false,
        publishDate = LocalDate.parse("2024-02-02")
    ),
        CourseDto(
            id = 101,
            title = "3D-дженералист",
            text = "Освой профессию 3D-дженералиста и стань универсальным специалистом, который умеет создавать 3D-модели, текстуры и анимации, а также может строить карьеру в геймдеве, кино, рекламе или дизайне.",
            price = 12000f,
            rate = 3.9f,
            startDate = LocalDate.parse("2024-09-10"),
            hasLike = false,
            publishDate = LocalDate.parse("2024-01-20")
        ),
        CourseDto(
            id = 102,
            title = "Python Advanced. Для продвинутых",
            text = "Вы узнаете, как разрабатывать гибкие и высокопроизводительные серверные приложения на языке Kotlin. Преподаватели на вебинарах покажут пример того, как разрабатывается проект маркетплейса: от идеи и постановки задачи – до конечного решения",
            price = 1299f,
            rate = 4.3f,
            startDate = LocalDate.parse("2024-10-12"),
            hasLike = true,
            publishDate = LocalDate.parse("2024-08-10")
        ),
        CourseDto(
            id = 103,
            title = "Системный аналитик",
            text = "Освоите навыки системной аналитики с нуля за 9 месяцев. Будет очень много практики на реальных проектах, чтобы вы могли сразу стартовать в IT.",
            price = 1199f,
            rate = 4.5f,
            startDate = LocalDate.parse("2024-04-15"),
            hasLike = false,
            publishDate = LocalDate.parse("2024-01-13")
        ),
        CourseDto(
            id = 104,
            title = "Аналитик данных",
            text = "В этом уроке вы узнаете, кто такой аналитик данных и какие задачи он решает. А главное — мы расскажем, чему вы научитесь по завершении программы обучения профессии «Аналитик данных».",
            price = 899f,
            rate = 4.7f,
            startDate = LocalDate.parse("2024-06-20"),
            hasLike = false,
            publishDate = LocalDate.parse("2024-03-12")
        ),)
    override suspend fun getAllCourses(): List<CourseDto> {
        return coursesRemote
    }

    override suspend fun updateCourseLike(courseLikeRequest: UpdateCourseLikeRequest): Boolean {
        val course = coursesRemote.indexOfFirst { it.id == courseLikeRequest.courseId }
        if(course == -1) return false
        coursesRemote[course].hasLike = !coursesRemote[course].hasLike
        return true
    }
}