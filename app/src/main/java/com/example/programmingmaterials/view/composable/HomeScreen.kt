package com.example.programmingmaterials.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.programmingmaterials.view.composable.cards.MaterialProgressCard2
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.navigation.Routes
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(navController: NavController) {
    ProgrammingMaterialsTheme {
        Scaffold() {
            it
            val viewModel = hiltViewModel<HomeScreenViewModel>()
            val screenState = viewModel.screenState

            HomeScreenContent(
                state = screenState.value,
                onMaterialClick = { materialId ->
                    navController.navigate(Routes.MaterialDetails.createRoute(materialId))
                }
            )
        }
    }
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    onMaterialClick: (Int) -> Unit
) {
    Column {
        Column {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp)),
                placeholder = { Text("Search...") },
                singleLine = true
            )
            Text(
                text = "Started materials",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                items(state.startedMaterialsList) {
                    MaterialProgressCard2(uiModel = it, cardColor = Color.LightGray, onClick = {onMaterialClick(it.id)})

                }
            }
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxSize()

        ) {
            Text(
                text = "Recomendation",
                modifier = Modifier.padding(8.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                items(state.newMaterialsList) {
                    MaterialProgressCard2(uiModel = it, cardColor = Color.Gray, onClick = {onMaterialClick(it.id)})
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    ProgrammingMaterialsTheme {
        HomeScreenContent(HomeScreenState()) {
        }
    }
}