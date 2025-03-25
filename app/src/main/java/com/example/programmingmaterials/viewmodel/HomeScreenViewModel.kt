package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.navigation.Routes

class HomeScreenViewModel : ViewModel() {
    private val initState = HomeScreenState()
    val screenState = mutableStateOf(initState)


    init {
        screenState.value = screenState.value.copy(
            newMaterialsList = listOf(
                MaterialProgressUiModel(
                    "Material1",
                    "Category1",
                    "Started"
                ),
                MaterialProgressUiModel(
                    "Material1",
                    "Category1",
                    "Started"
                ),
                MaterialProgressUiModel(
                    "Material1",
                    "Category1",
                    "Started"
                )
            )
        )
    }
}