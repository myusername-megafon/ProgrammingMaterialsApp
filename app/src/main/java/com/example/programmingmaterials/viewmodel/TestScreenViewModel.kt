package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.programmingmaterials.model.TestScreenState
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class TestScreenViewModel : ViewModel() {
    private val _state = mutableStateOf<TestScreenState>()
    val state: State<TestScreenState> = _state
}
