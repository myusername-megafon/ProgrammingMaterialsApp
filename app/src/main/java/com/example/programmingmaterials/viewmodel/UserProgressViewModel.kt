package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.MaterialProgressUiModel
import kotlinx.coroutines.launch

class UserProgressViewModel(
) : ViewModel() {

    val statusList = mutableStateOf(listOf(
        MaterialProgressUiModel("Material 1", "Category 1", "Started"),
        MaterialProgressUiModel("Material 2", "Category 2", "Started"),
    ))

    fun onBackClick() {

    }

    init {
        viewModelScope.launch {
        }
    }
}