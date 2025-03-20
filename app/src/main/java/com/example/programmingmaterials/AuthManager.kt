package com.example.programmingmaterials

import kotlinx.coroutines.delay

class AuthManager {


    fun isLoggedIn() : Boolean {
        return false
    }

    suspend fun logIn(email: String, password: String) : Boolean{

        delay(1000)
        return true

    }
}
