package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.programmingmaterials.data.ProfileRepo
import com.example.programmingmaterials.model.UserProgressScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProgressScreenViewModel @Inject constructor(
    private val profileRepo: ProfileRepo
) : ViewModel() {

    private val initialScreenState = UserProgressScreenState()
    val screenState = mutableStateOf(initialScreenState)

    fun onBackClick() {

    }

    init {
        viewModelScope.launch {
            val startedMaterials = profileRepo.getStartedMaterials()
            screenState.value = screenState.value.copy(materialProgressList = startedMaterials.map {
                val materialName = it.materialPath.split("/")[1]
                val materialCategory = it.materialPath.split("/")[0]
                return@map MaterialProgressUiModel(materialName, materialCategory, it.status)
            })
        }
    }

    fun onClickStatusMenuButton() {
        screenState.value = screenState.value.copy(isStatusMenuExpanded = true)
    }

    fun onDismissStatusMenu() {
        screenState.value = screenState.value.copy(isStatusMenuExpanded = false)
    }

    fun onClickCategoryMenuButton() {
        screenState.value = screenState.value.copy(isCategoryMenuExpanded = true)
    }

    fun onDismissCategoryMenu() {
        screenState.value = screenState.value.copy(isCategoryMenuExpanded = false)
    }
}