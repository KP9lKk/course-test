package com.example.ui.screens.main

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Settings
import com.example.domain.usecase.settings.SettingsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(private val settingsUseCase: SettingsUseCase): ViewModel() {
    private val _settings = MutableStateFlow(Settings())
    val settings = _settings.asStateFlow()
    var navigateToLogin: (() -> Unit)? = null
    var navigateToMain: (() -> Unit)? = null
    fun setIsFirstOpen(){
        viewModelScope.launch {
            settingsUseCase.setIsFirstOpen()
        }
    }
    init {
        _settings.value = runBlocking { settingsUseCase.settings.first() }
    }

}