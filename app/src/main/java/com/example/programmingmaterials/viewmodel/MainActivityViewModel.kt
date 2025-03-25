package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.programmingmaterials.navigation.Routes

class MainActivityViewModel: ViewModel() {
    private val initState = MainActivityState()
    val state = mutableStateOf(initState)

    fun navigateTo(route: Any){
        state.value = state.value.copy(enabledScreen = route)
    }
}



data class MainActivityState(val enabledScreen: Any = Routes.Home)