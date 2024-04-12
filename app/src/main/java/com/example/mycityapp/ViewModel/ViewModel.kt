package com.example.mycityapp.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mycityapp.data.UiState
import com.example.mycityapp.dataClass.Category
import com.example.mycityapp.dataClass.Recommendation


class ViewModel: ViewModel() {

    fun updateCurrentCategory(category: Category) {
        Log.d("CityApp", "updateCurrentCategory")
        UiState.currentCategory = category
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        Log.d("CityApp", "updateCurrentRecommendation")
        UiState.currentRecommendation = recommendation
    }

    init {
        Log.d("CityApp", "ViewModel created")
    }
}