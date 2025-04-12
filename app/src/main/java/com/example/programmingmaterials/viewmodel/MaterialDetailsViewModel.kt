package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.data.MaterialRepo
import com.example.programmingmaterials.model.MaterialDetailsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MaterialDetailsViewModel @Inject constructor(
    materialRepo: MaterialRepo
) : ViewModel() {
    private val initState = MaterialDetailsScreenState()
    val state = mutableStateOf(initState)

    init {
        viewModelScope.launch {
            materialRepo.getMaterialById()
        }
    }
}

