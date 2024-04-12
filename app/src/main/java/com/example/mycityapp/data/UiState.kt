package com.example.mycityapp.data

import com.example.mycityapp.dataClass.Category
import com.example.mycityapp.dataClass.Recommendation

data class UiState(
    var currentCategory: Category = Category("", 0, listOf()),
    var currentRecommendation: Recommendation = Recommendation(0, "", "")
) {
    companion object {
        private var _currentRecommendation: Recommendation = Recommendation(0, "", "")
        private var _currentCategory: Category = Category("", 0, listOf())

        var currentRecommendation: Recommendation
            get() = _currentRecommendation
            set(value) {
                _currentRecommendation = value
            }

        var currentCategory: Category
            get() = _currentCategory
            set(value) {
                _currentCategory = value
            }
    }
}
