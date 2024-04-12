package com.example.mycityapp.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Recommendations: Screen("recommendations")
    object Details: Screen("details")
}