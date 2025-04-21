package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.data.repositories.MaterialRepo
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
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
            val newMaterials = materialRepo.getNewMaterials(1)
            val startedMaterials = materialRepo.getStartedMaterials(1)
            screenState.value = screenState.value.copy(
                newMaterialsList = newMaterials.map {
                    MaterialProgressUiModel(
                        id = it.id,
                        materialName = it.name,
                        categoryName = it.category,
                        status = "New"
                    )
                },
                startedMaterialsList = startedMaterials.map {
                    MaterialProgressUiModel(
                        id = it.id,
                        materialName = it.name,
                        categoryName = it.category,
                        status = "New"
                    )
                }
            )
        }
    }
}