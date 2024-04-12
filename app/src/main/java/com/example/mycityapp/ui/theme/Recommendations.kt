package com.example.mycityapp.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycityapp.Navigation.Screen
import com.example.mycityapp.ViewModel.ViewModel
import com.example.mycityapp.data.UiState
import com.example.mycityapp.data.categories
import com.example.mycityapp.dataClass.Recommendation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationCard(
    navController: NavController,
    recommendation: Recommendation,
    modifier: Modifier = Modifier,
) {
    val viewModel: ViewModel = viewModel()
    Card(
        modifier = modifier
            .padding(5.dp)
            .shadow(8.dp), // Add padding to the card
        shape = RoundedCornerShape(16.dp), // Apply rounded corners to the card
        onClick = {
            Log.d("CityApp", "Recommendation clicked")
            viewModel.updateCurrentRecommendation(recommendation)
            navController.navigate(Screen.Details.route)

        },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp), // Add padding to the row
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = null, // Update with appropriate content description
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(8.dp)) // Apply rounded corners to the image
            )
            Spacer(modifier = Modifier.width(16.dp)) // Add spacing between the image and text
            Text(
                text = recommendation.name,
                modifier = Modifier.weight(1f), // Allow the text to take remaining space
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun Recommendation(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Log.d("CityApp", "Recommendation screen crashed")
    val viewModel: ViewModel = viewModel()

    Scaffold(
        topBar = {
            RecommendationsTopAppBar(UiState.currentCategory.name, modifier)
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(UiState.currentCategory.recommendations) { recommendation ->
                RecommendationCard(recommendation = recommendation, navController = navController, modifier = modifier)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationsTopAppBar(selectedCategoryName: String, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = categories.find { it.name == selectedCategoryName }?.image ?: UiState.currentCategory.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(60.dp) // Set the height of the image
                        .aspectRatio(1f) // Maintain aspect ratio
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Add spacing between the image and text
                Text(
                    text = selectedCategoryName,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold, // Apply bold font weight
                    modifier = Modifier.padding(bottom = 8.dp) // Add padding to the text
                )
            }
        },
        modifier = modifier
    )
}


@Preview
@Composable
fun RecommendationPreview() {
    Recommendation(navController = rememberNavController(), modifier = Modifier)
}
