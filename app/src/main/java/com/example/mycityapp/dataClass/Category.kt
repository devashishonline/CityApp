package com.example.mycityapp.dataClass

data class Category(
    val name: String,
    var image: Int,
    val recommendations: List<Recommendation>
)

