package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.programmingmaterials.model.UserProfileScreenState
import com.example.programmingmaterials.navigation.Routes

class UserProfileScreenViewModel(): ViewModel() {
    private val initState = UserProfileScreenState()
    val state = mutableStateOf(initState)

    fun onMyMaterialsButtonClick(){

    }
}