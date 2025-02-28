@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.programmingmaterials.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.programmingmaterials.MaterialProgressUiModel
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.UserProgressViewModel


@Composable
@Preview(showBackground = true)
fun MainScreen() {
    ProgrammingMaterialsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            it
            val viewModel: UserProgressViewModel = viewModel()
            ScreenContent(
                viewModel.statusList.value,
                { viewModel.onBackClick() }
            )
        }
    }
}


@Composable
fun ScreenContent(
    statuses: List<MaterialProgressUiModel>,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { Text("Progress") },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        )
        LazyColumn {
            items(statuses) { uiModel ->
                MaterialProgress(uiModel)
            }
        }
    }
}

@Composable
@Preview
fun PreviewScree(modifier: Modifier = Modifier) {
    ProgrammingMaterialsTheme {
        ScreenContent(listOf(
            MaterialProgressUiModel("Material 1", "Category 1", "Started"),
            MaterialProgressUiModel("Material 2", "Category 2", "Started"),
        ), onBackClick = { })
    }

}