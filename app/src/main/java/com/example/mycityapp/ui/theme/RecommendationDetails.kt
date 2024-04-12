package com.example.mycityapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycityapp.data.UiState
import com.example.mycityapp.dataClass.Recommendation

@Composable
fun RecommendationDetailsCard(recommendation: Recommendation, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        )
    {
        Spacer(modifier = modifier.height(10.dp))
        Image(
            painter = painterResource(id = recommendation.image),
            contentDescription = null, // Update with appropriate content description
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp), // Adjust the height as needed
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(16.dp)) // Add spacing between the image and text
        Text(
            text = recommendation.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(bottom = 8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationsDetailsTopAppBar(title: String, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title, // Use title passed as parameter
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        },
        modifier = modifier
    )
}


@Composable
fun RecommendationDetailsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        RecommendationsDetailsTopAppBar(title = UiState.currentRecommendation.name, modifier = modifier)
        RecommendationDetailsCard(recommendation = UiState.currentRecommendation, modifier = modifier)
    }
}


@Preview
@Composable
fun RecommendationCardPreview() {
    RecommendationDetailsScreen()
}