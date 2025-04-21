package com.example.programmingmaterials.model

data class HomeScreenState(
    val startedMaterialsList: List<MaterialProgressUiModel> = listOf(),
    val newMaterialsList: List<MaterialProgressUiModel> = listOf())
