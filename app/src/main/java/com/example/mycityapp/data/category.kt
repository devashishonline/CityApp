package com.example.mycityapp.data

import com.example.mycityapp.R
import com.example.mycityapp.dataClass.Category

val coffeeShopCategory = Category("Coffee Shop", R.drawable.coffee_shop, coffeeShopRecommendations)
val restaurantCategory = Category("Restaurant", R.drawable.restaurant, restaurantRecommendations)
val salonCategory = Category("Salon", R.drawable.salon, salonRecommendations)
val tourismCategory = Category("Tourism", R.drawable.tourism, tourismRecommendations)


val categories = listOf(coffeeShopCategory, restaurantCategory, salonCategory, tourismCategory)