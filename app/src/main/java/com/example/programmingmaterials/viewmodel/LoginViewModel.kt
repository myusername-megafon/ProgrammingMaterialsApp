package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.AuthManager
import com.example.programmingmaterials.model.LoginEvent
import com.example.programmingmaterials.model.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val authManager: AuthManager = AuthManager()

    private val initialState = LoginState()
    val state: MutableState<LoginState> = mutableStateOf(initialState)
    val event: MutableState<LoginEvent?> = mutableStateOf(null)

    init {
        if (authManager.isLoggedIn()) {
            navigateMain()
        }
    }

    fun onEditEmail(newEmailText: String) {
        state.value = state.value.copy(emailText = newEmailText)
    }

    fun onEditPassword(passwordText: String) {
        state.value = state.value.copy(passwordText = passwordText)
    }

    fun onClickButton() {
        viewModelScope.launch {
            state.value = state.value.copy(isProgress = true)
            authManager.logIn(state.value.emailText, state.value.passwordText)
            state.value = state.value.copy(isProgress = false)
            navigateMain()
        }
    }

    private fun navigateMain() {
        event.value = LoginEvent.NavigateMain()
    }
}