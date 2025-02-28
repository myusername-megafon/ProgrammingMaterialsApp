package com.example.programmingmaterials.viewmodel

import androidx.lifecycle.ViewModel
import com.example.programmingmaterials.AuthManager

class LoginViewModel : ViewModel() {
    private val authManager: AuthManager = AuthManager()

    init {
        if (authManager.isLoggedIn()) {
            navigateMain()
        }
    }



    private fun navigateMain() {

    }
}