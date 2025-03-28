package com.example.data.local.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.data.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsDataSourceImpl(private val dataStore: DataStore<Preferences>) : SettingsDataSource {
    override val settings: Flow<Settings>
        get() = dataStore.data.map {
            Settings(
                isFirstOpen = it[IS_FIRST_OPEN] ?: true
            )
        }

    override suspend fun setIsFirstOpen() {
        dataStore.edit {
            it[IS_FIRST_OPEN] = false
        }
    }
    companion object DataStoreKey{
         val IS_FIRST_OPEN = booleanPreferencesKey("is_first_open")
    }
}