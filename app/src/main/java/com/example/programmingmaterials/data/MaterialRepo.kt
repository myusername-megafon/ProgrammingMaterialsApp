package com.example.programmingmaterials.data

import com.example.programmingmaterials.RetrofitClient
import javax.inject.Inject

class MaterialRepo @Inject constructor() {

    suspend fun getMaterialById(): Material {
        return Material(
            1,
            "Material",
            "Its very interesting content",
            Category("Web-development", "Easy"),
            Author("Name Author")
        )
    }

    suspend fun getAllNewMaterials(userId: String): List<Material> {
        val materials = RetrofitClient.apiService.getNewMaterials(userId)
        return materials
    }
}
