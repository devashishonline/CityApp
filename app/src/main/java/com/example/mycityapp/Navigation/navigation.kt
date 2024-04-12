package com.example.mycityapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.ui.theme.CityApp
import com.example.mycityapp.ui.theme.Recommendation
import com.example.mycityapp.ui.theme.RecommendationDetailsScreen

@Composable
fun Navigation(padding: Any) {

    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            CityApp(navController)
        }
        composable(Screen.Recommendations.route) {
            Recommendation(navController)
        }
        composable(Screen.Details.route) {
            RecommendationDetailsScreen()
        }
    }
}