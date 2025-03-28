package com.example.data.local.settings

import com.example.data.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {
    val settings: Flow<Settings>
    suspend fun setIsFirstOpen()
}