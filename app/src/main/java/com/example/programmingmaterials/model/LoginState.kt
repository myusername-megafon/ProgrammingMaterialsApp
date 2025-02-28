package com.example.programmingmaterials.model

data class LoginState(
    val emailText: String = "",
    val passwordText: String = "",
    val isProgress: Boolean = false
)