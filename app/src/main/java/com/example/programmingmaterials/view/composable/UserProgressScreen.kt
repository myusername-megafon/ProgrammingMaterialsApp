@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.programmingmaterials.view.composable

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.view.composable.cards.MaterialProgressCard
import com.example.programmingmaterials.model.UserProgressScreenState
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.UserProgressScreenViewModel

@Composable
fun UserProgressScreen(navController: NavController) {
    ProgrammingMaterialsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            it
            val viewModel: UserProgressScreenViewModel = hiltViewModel()
            UserProgressScreenContent(
                navController = navController,
                viewModel.screenState.value,
                { viewModel.onClickStatusMenuButton() },
                { viewModel.onDismissStatusMenu() },
                { viewModel.onClickCategoryMenuButton() },
                { viewModel.onDismissCategoryMenu() },
                { category -> viewModel.onCategorySelected(category) },
                { status -> viewModel.onStatusSelected(status) },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProgressScreenContent(
    navController: NavController,
    stateScreen: UserProgressScreenState,
    onStatusMenuButtonClick: () -> Unit,
    onDismissStatusMenu: () -> Unit,
    onCategoryMenuButtonClick: () -> Unit,
    onDismissCategoryMenu: () -> Unit,
    onCategorySelected: (String) -> Unit,
    onStatusSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { Text("Progress") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
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
                Text(stateScreen.selectedStatus ?: "Status")
                DropdownMenu(
                    expanded = stateScreen.isStatusMenuExpanded,
                    onDismissRequest = { onDismissStatusMenu() }
                ) {
                    stateScreen.statusMenuItemsList.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = { onStatusSelected(status) }
                        )
                    }
                }
            }

            Button(onClick = { onCategoryMenuButtonClick() }) {
                Icon(Icons.AutoMirrored.Default.List, null)
                Text(
                    stateScreen.selectedCategory ?: "Category",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                DropdownMenu(
                    expanded = stateScreen.isCategoryMenuExpanded,
                    onDismissRequest = { onDismissCategoryMenu() }
                ) {
                    stateScreen.categoryMenuItemsList.map { category ->
                        DropdownMenuItem(
                            text = { Text(category) },
                            onClick = { onCategorySelected(category) }
                        )
                    }
                }
            }
        }
        LazyColumn {
            items(stateScreen.filteredMaterials) { uiModel ->
                MaterialProgressCard(uiModel = uiModel, onClick = { materialId ->
                    navController.navigate("material_details/$materialId")
                })
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewScreen(modifier: Modifier = Modifier) {
    ProgrammingMaterialsTheme {
        UserProgressScreenContent(
            rememberNavController(),
            UserProgressScreenState(
                materialProgressList = listOf(
                    MaterialProgressUiModel(1, "Material 1", "Category 1", "Started"),
                    MaterialProgressUiModel(2, "Material 2", "Category 2", "Started"),
                )
            ),
            onStatusMenuButtonClick = {},
            onDismissStatusMenu = {},
            onCategoryMenuButtonClick = {},
            onDismissCategoryMenu = {},
            onCategorySelected = {},
            onStatusSelected = {})
    }
}