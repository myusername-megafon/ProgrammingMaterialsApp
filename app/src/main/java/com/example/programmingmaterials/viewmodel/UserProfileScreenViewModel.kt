package com.example.programmingmaterials.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingmaterials.data.repositories.ProfileRepo
import com.example.programmingmaterials.model.UserProfileScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileScreenViewModel @Inject constructor(
    private val profileRepo: ProfileRepo
) : ViewModel() {
    private val initState = UserProfileScreenState()
    val state = mutableStateOf(initState)

    init {
        viewModelScope.launch {
            val user = profileRepo.getUser(1)
            val userProgressInNumbers = profileRepo.getUserProgressInNumbers(1)
            state.value = state.value.copy(
                userName = user.name,
                startedMaterials = userProgressInNumbers.startedMaterials,
                pendingMaterials = userProgressInNumbers.pendingMaterials,
                finishedMaterials = userProgressInNumbers.finishedMaterials
            )
        }
    }
}