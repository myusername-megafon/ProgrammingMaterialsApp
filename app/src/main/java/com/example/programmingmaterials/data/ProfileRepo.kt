package com.example.programmingmaterials.data

import kotlinx.coroutines.delay

class ProfileRepo {
    suspend fun getStartedMaterials(): List<MaterialProgress>{
        delay(2000)
        return listOf(
            MaterialProgress("web/htmltext","started"),
            MaterialProgress("mobile/kotlin","started")
        )
    }
}