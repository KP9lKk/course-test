package com.example.course

import android.app.Application
import com.example.course.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CourseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModules)
        }
    }
}