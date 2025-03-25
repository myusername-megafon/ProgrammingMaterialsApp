package com.example.programmingmaterials.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.model.HomeScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.navigation.Routes
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen() {
    ProgrammingMaterialsTheme {
        Scaffold() {
            it
            val viewModel = viewModel<HomeScreenViewModel>()
            val screenState = viewModel.screenState

            HomeScreenContent(screenState.value)
        }
    }
}

@Composable
fun HomeScreenContent(state: HomeScreenState) {
    Column(modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)) {
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
                items(state.newMaterialsList) {
                    MaterialProgressCard2(uiModel = it, cardColor = Color.LightGray)
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
                    MaterialProgressCard2(uiModel = it, cardColor = Color.Gray)
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    ProgrammingMaterialsTheme {
        val testList = listOf(
            MaterialProgressUiModel(
                "Material1",
                "Category1",
                "Started"
            ),
            MaterialProgressUiModel(
                "Material1",
                "Category1",
                "Started"
            ),
            MaterialProgressUiModel(
                "Material1",
                "Category1",
                "Started"
            ),
            MaterialProgressUiModel(
                "Material1",
                "Category1",
                "Started"
            ),
            MaterialProgressUiModel(
                "Material1",
                "Category1",
                "Started"
            )
        )
        HomeScreenContent(HomeScreenState(testList))
    }
}