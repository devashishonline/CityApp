package com.example.mycityapp.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mycityapp.Navigation.Screen
import com.example.mycityapp.R
import com.example.mycityapp.ViewModel.ViewModel
import com.example.mycityapp.data.categories
import com.example.mycityapp.dataClass.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    navController: NavController,
    category: Category,
    modifier: Modifier = Modifier,
) {
    val viewModel: ViewModel = viewModel()
    Card(
        modifier = modifier
            .padding(5.dp)
            .shadow(8.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            Log.d("CityApp", "Category clicked")
            viewModel.updateCurrentCategory(category)
            navController.navigate(Screen.Recommendations.route)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.name,
                modifier = Modifier
                    .weight(0.3f),
                contentScale = ContentScale.Fit

            )
            Text(
                text = category.name,
                modifier = Modifier
                    .weight(0.7f)
                    .padding(40.dp),
                style = MaterialTheme.typography.bodyLarge,
            )
        }


    }
}

@Composable
fun CityApp(
    navController: NavController,
    modifier: Modifier = Modifier
) {


    Scaffold(
        topBar = {
            MyCityTopAppBar()
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(categories) { category ->
                CategoryCard(category = category, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mycity),
                    contentDescription = stringResource(R.string.my_city_name),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(50.dp)
                        .aspectRatio(1f)
                        .padding(5.dp)

                )
                Text(
                    text = stringResource(R.string.my_city_name),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .padding(1.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        },
        modifier = modifier
    )
}

//@Preview
//@Composable
//fun CategoryCardPreview() {
//    CategoryCard(
//        category = categories[0]
//    )
//}
//
//@Preview
//@Composable
//fun CityAppPreview() {
//    CityApp(Modifier)
//}