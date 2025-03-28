package com.example.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.command.LoginCommand
import com.example.domain.usecase.auth.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel(authUseCase: AuthUseCase): ViewModel() {
    val vkUrl: String = "https://vk.com/"
    val okUrl: String = "https://ok.ru/"
    private val _loginScreenMutableState = MutableStateFlow(LoginScreenState())
    val loginScreenStateFlow = _loginScreenMutableState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _loginScreenMutableState.collect{ it ->
                val loginCommand = LoginCommand(email = it.email, password = it.password)
                val buttonIsEnable = authUseCase.login(loginCommand)
                if (buttonIsEnable != it.buttonIsEnable) _loginScreenMutableState.update {
                    it.copy(buttonIsEnable = buttonIsEnable)
                }
            }
        }
    }

    fun setEmail(email: String){
       viewModelScope.launch(Dispatchers.IO) {
           _loginScreenMutableState.update {
               it.copy(email = email)
           }
       }
    }
    fun setPassword(password: String){
        viewModelScope.launch(Dispatchers.IO) {
            _loginScreenMutableState.update {
                it.copy(password = password)
            }
        }
    }

}