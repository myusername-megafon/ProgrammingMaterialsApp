package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.programmingmaterials.AuthManager
import com.example.programmingmaterials.model.LoginState

class LoginViewModel : ViewModel() {
    private val authManager: AuthManager = AuthManager()

    private val initialState = LoginState()
    val state: MutableState<LoginState> = mutableStateOf(initialState)

    init {
        if (authManager.isLoggedIn()) {
            navigateMain()
        }
    }

    fun onEditEmail(newEmailText: String){
        state.value = state.value.copy(emailText = newEmailText)
    }

    fun onEditPassword(passwordText: String){
        state.value = state.value.copy(passwordText = passwordText)

    }

    fun onClickButton() {

    }

    private fun navigateMain() {

    }
}