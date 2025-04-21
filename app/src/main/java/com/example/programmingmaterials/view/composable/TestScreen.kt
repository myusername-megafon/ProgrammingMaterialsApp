package com.example.programmingmaterials.view.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.model.FeedbacksScreenState
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.view.composable.cards.ReviewCard
import com.example.programmingmaterials.viewmodel.FeedbacksScreenViewModel
import com.example.programmingmaterials.viewmodel.LoginViewModel
import com.example.programmingmaterials.viewmodel.TestScreenViewModel

@Composable
fun TestScreen(navController: NavController) {
    ProgrammingMaterialsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            it
            val viewModel = hiltViewModel<TestScreenViewModel>()
            val state = viewModel.state.value
            FeedbacksScreenContent(
                state = state,
                navController = navController
            ) { feedbackId ->
                viewModel.onClickDeleteButton(feedbackId)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreenContent(
    state: FeedbacksScreenState,
    navController: NavController,
    onClickDeleteButton: (Int) -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(text = "Мои Отзывы") },
            modifier = Modifier,
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        )
        LazyColumn(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            items(state.feedbacksList) {
                ReviewCard(it, "FeedbacksScreen") { feedbackId ->
                    onClickDeleteButton(
                        feedbackId
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestScreenPreview() {
    ProgrammingMaterialsTheme {
        FeedbacksScreen(rememberNavController())
    }
}