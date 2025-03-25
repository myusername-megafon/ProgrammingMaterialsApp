package com.example.programmingmaterials.model

data class HomeScreenState(
    val newMaterialsList: List<MaterialProgressUiModel> = listOf(),
    val recMaterialsList: List<MaterialProgressUiModel> = listOf())
