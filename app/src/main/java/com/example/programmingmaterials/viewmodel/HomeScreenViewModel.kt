package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.data.MaterialRepo
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val materialRepo: MaterialRepo
) : ViewModel() {
    private val initState = HomeScreenState()
    val screenState = mutableStateOf(initState)

    init {
        viewModelScope.launch {
            val newMaterials = materialRepo.getAllNewMaterials("1")
            screenState.value = screenState.value.copy(
                newMaterialsList = newMaterials.map {
                    MaterialProgressUiModel(
                        materialName = it.name,
                        categoryName = it.category.name,
                        status = "New"
                    )
                }
            )
        }

    }
}