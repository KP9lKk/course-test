package com.example.domain.usecase.settings

import com.example.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    val settings: Flow<Settings>
    suspend fun setIsFirstOpen()
}