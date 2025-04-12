package com.example.programmingmaterials.data

data class Material(
    val id: Int,
    val name: String,
    val content: String,
    val category: Category,
    val author: Author
)

data class Category(
    val id: Int,
    val name: String,
    val difficulty: String
)

data class Author(
    val id: Int,
    val name: String
)