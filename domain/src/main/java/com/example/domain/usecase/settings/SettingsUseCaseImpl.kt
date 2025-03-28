package com.example.domain.usecase.settings

import com.example.domain.model.Settings
import com.example.data.local.settings.SettingsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsUseCaseImpl(private val settingsDataSource: SettingsDataSource): SettingsUseCase {
    override val settings: Flow<Settings>
        get() = settingsDataSource.settings.map {
            Settings(it.isFirstOpen)
        }

    override suspend fun setIsFirstOpen() {
        settingsDataSource.setIsFirstOpen()
    }
}