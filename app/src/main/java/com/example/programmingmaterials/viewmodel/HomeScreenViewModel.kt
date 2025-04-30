package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.AuthManager
import com.example.programmingmaterials.R
import com.example.programmingmaterials.data.repositories.MaterialRepo
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val materialRepo: MaterialRepo,
    private val authManager: AuthManager
) : ViewModel() {
    private val initState = HomeScreenState()
    val screenState = mutableStateOf(initState)
    val userId = authManager.getUserId()

    init {
        viewModelScope.launch {
            val images = listOf(
                R.drawable.it_photo1,
                R.drawable.it_photo2,
                R.drawable.it_photo3,
                R.drawable.it_photo4,
                R.drawable.it_photo5,
                R.drawable.it_photo6,
                R.drawable.it_photo7,
                R.drawable.it_photo8,
                R.drawable.it_photo9,
                R.drawable.it_photo10,
                R.drawable.it_photo11,
                R.drawable.it_photo12,
                R.drawable.it_photo13,
                R.drawable.it_photo14,
                R.drawable.it_photo15
            )
            val newMaterials = materialRepo.getNewMaterials(userId)
            val startedMaterials = materialRepo.getStartedMaterials(userId)
            screenState.value = screenState.value.copy(
                newMaterialsList = newMaterials.map {
                    MaterialProgressUiModel(
                        id = it.id,
                        materialName = it.name,
                        categoryName = it.category,
                        status = "New",
                        image = images.random()
                    )
                },
                startedMaterialsList = startedMaterials.map {
                    MaterialProgressUiModel(
                        id = it.id,
                        materialName = it.name,
                        categoryName = it.category,
                        status = "New",
                        image = images.random()
                    )
                }
            )
        }
    }
}