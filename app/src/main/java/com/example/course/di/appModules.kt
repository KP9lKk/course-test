package com.example.course.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.local.settings.SettingsDataSource
import com.example.data.local.settings.SettingsDataSourceImpl
import com.example.data.remote.network.CourseApi
import com.example.data.remote.network.CourseApiImpl
import com.example.data.repository.course.CourseRepository
import com.example.data.repository.course.CourseRepositoryImpl
import com.example.domain.usecase.auth.AuthUseCase
import com.example.domain.usecase.auth.AuthUseCaseImpl
import com.example.domain.usecase.course.CourseUseCase
import com.example.domain.usecase.course.CourseUseCaseImpl
import com.example.domain.usecase.settings.SettingsUseCase
import com.example.domain.usecase.settings.SettingsUseCaseImpl
import com.example.ui.screens.auth.LoginScreenViewModel
import com.example.ui.screens.favorite.FavoriteScreenViewModel
import com.example.ui.screens.home.HomeScreenViewModel
import com.example.ui.screens.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

val appModules = module{
    single<AuthUseCase> { AuthUseCaseImpl() }
    viewModel<LoginScreenViewModel> { LoginScreenViewModel(get()) }
    single<SettingsDataSource> { SettingsDataSourceImpl(androidContext().dataStore)}
    single<SettingsUseCase> { SettingsUseCaseImpl(get()) }
    single<CourseApi> { CourseApiImpl() }
    single<CourseRepository> { CourseRepositoryImpl(get())}
    single<CourseUseCase> { CourseUseCaseImpl(get()) }
    viewModel<MainViewModel> {(MainViewModel(get()))}
    viewModel<HomeScreenViewModel> { HomeScreenViewModel(get()) }
    viewModel<FavoriteScreenViewModel> { FavoriteScreenViewModel(get()) }
}