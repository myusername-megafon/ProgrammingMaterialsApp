@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.programmingmaterials.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.programmingmaterials.model.UserProgressScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.UserProgressScreenViewModel

@Composable
fun UserProgressScreen() {

    ProgrammingMaterialsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            it
            val viewModel: UserProgressScreenViewModel = viewModel()
            UserProgressScreenContent(
                viewModel.screenState.value,
                { viewModel.onBackClick() },
                { viewModel.onClickStatusMenuButton() },
                { viewModel.onDismissStatusMenu() },
                { viewModel.onClickCategoryMenuButton() },
                { viewModel.onDismissCategoryMenu() }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProgressScreenContent(
    stateScreen: UserProgressScreenState,
    onBackClick: () -> Unit,
    onStatusMenuButtonClick: () -> Unit,
    onDismissStatusMenu: () -> Unit,
    onCategoryMenuButtonClick: () -> Unit,
    onDismissCategoryMenu: () -> Unit
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
        Row {
            Button(onClick = { onStatusMenuButtonClick() }) {
                Icon(Icons.AutoMirrored.Default.List, null)
                Text("StatusMaterial")
                DropdownMenu(
                    expanded = stateScreen.isStatusMenuExpanded,
                    onDismissRequest = { onDismissStatusMenu() }) {
                    stateScreen.statusMenuItemsList.forEach { item ->
                        DropdownMenuItem(text = { Text(text = item) }, onClick = {})
                    }
                }
            }
            Button(onClick = { onCategoryMenuButtonClick() }) {
                Icon(Icons.AutoMirrored.Default.List, null)
                Text("Category")
                DropdownMenu(
                    expanded = stateScreen.isCategoryMenuExpanded,
                    onDismissRequest = { onDismissCategoryMenu() }) {
                    stateScreen.categoryMenuItemsList.forEach { item ->
                        DropdownMenuItem(text = { Text(text = item) }, onClick = {})
                    }
                }
            }
        }
        LazyColumn {
            items(stateScreen.materialProgressList) { uiModel ->
                MaterialProgressCard(uiModel)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewScreen(modifier: Modifier = Modifier) {
    ProgrammingMaterialsTheme {
        UserProgressScreenContent(
            UserProgressScreenState(
                materialProgressList = listOf(
                    MaterialProgressUiModel("Material 1", "Category 1", "Started"),
                    MaterialProgressUiModel("Material 2", "Category 2", "Started"),
                )
            ),
            onBackClick = { },
            onStatusMenuButtonClick = {},
            onDismissStatusMenu = {},
            onCategoryMenuButtonClick = {},
            onDismissCategoryMenu = {})
    }
}