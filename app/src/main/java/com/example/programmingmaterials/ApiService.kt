package com.example.programmingmaterials

import com.example.programmingmaterials.data.Material
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("materials/new")
    suspend fun getNewMaterials(@Query("userId") userId: String): List<Material>

    @GET("materials")
    suspend fun getAllMaterials(): List<Material>
}