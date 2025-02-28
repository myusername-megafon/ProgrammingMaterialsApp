package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.programmingmaterials.AuthManager
import com.example.programmingmaterials.model.LoginState

class LoginViewModel : ViewModel() {
    private val authManager: AuthManager = AuthManager()

    private val initialState = LoginState()
    val state: State<LoginState> = mutableStateOf(initialState)

    init {
        if (authManager.isLoggedIn()) {
            navigateMain()
        }
    }



    private fun navigateMain() {

    }
}