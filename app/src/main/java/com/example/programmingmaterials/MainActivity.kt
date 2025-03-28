package com.example.programmingmaterials

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.composable.HomeScreen
import com.example.programmingmaterials.composable.UserProfileScreen
import com.example.programmingmaterials.composable.UserProgressScreen
import com.example.programmingmaterials.navigation.Routes
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.MainActivityViewModel
import com.example.programmingmaterials.viewmodel.UserProfileScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgrammingMaterialsTheme {
                val navController = rememberNavController()
                val viewModel = viewModel<MainActivityViewModel>()
                Scaffold(
                    bottomBar = { BottomMenu(navController, viewModel) },
                    modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
                ) {
                    it
                    NavHost(navController, startDestination = Routes.Home) {
                        composable<Routes.Home> { HomeScreen() }
                        composable<Routes.UserProgress> { UserProgressScreen() }
                        composable<Routes.UserProfile> { UserProfileScreen(navController) }
                    }
                }
            }
        }
    }

    @Composable
    fun BottomMenu(navController: NavController, viewModel: MainActivityViewModel) {
        NavigationBar(modifier = Modifier) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, null) },
                label = { Text("Home") },
                selected = viewModel.state.value.enabledScreen == Routes.Home,
                onClick = {
                    navController.navigate(Routes.Home)
                    viewModel.navigateTo(Routes.Home)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.AccountCircle, null) },
                label = { Text("Profile") },
                selected = viewModel.state.value.enabledScreen == Routes.UserProfile,
                onClick = {
                    navController.navigate(Routes.UserProfile)
                    viewModel.navigateTo(Routes.UserProfile)
                }
            )
        }
    }
}
