package com.example.programmingmaterials.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.programmingmaterials.model.UserProfileScreenState
import com.example.programmingmaterials.navigation.Routes
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.UserProfileScreenViewModel

@Composable
fun UserProfileScreen(navHostController: NavHostController) {
    ProgrammingMaterialsTheme {
        Scaffold {
            it
            val viewModel = hiltViewModel<UserProfileScreenViewModel>()
            val state = viewModel.state.value
            UserProfileScreenContent(state,navHostController)
        }
    }
}

@Composable
fun UserProfileScreenContent(state: UserProfileScreenState,navHostController: NavHostController) {
    Column {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                )
                .background(Color.Gray)
                .fillMaxWidth()
        ) {
            Text(text = "Profile", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null,
                modifier = Modifier
                    .size(116.dp)
                    .padding(8.dp)
            )
            Text(
                text = "Hello, " + state.userName,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Spacer(Modifier.size(8.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                "Your progress",
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp
            )
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.DarkGray)
                        .weight(1f)
                ) {
                    Text(
                        text = state.finishedMaterials.toString(),
                        color = Color.Blue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        "finished",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.DarkGray)
                        .weight(1f)
                ) {
                    Text(
                        text = state.pendingMaterials.toString(),
                        color = Color.Blue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        "pending",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.DarkGray)
                        .weight(1f)
                ) {
                    Text(
                        text = state.startedMaterials.toString(),
                        color = Color.Blue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        "started",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        }
        Spacer(Modifier.size(8.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
                .background(Color.Gray)
                .fillMaxSize()
        ) {
            Button(
                onClick = {navHostController.navigate(Routes.UserProgress)},
                colors = ButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                Text("My Materials", fontSize = 20.sp)
            }
            HorizontalDivider()
            Button(
                onClick = { navHostController.navigate(Routes.UserFeedbacks) },
                colors = ButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Create, contentDescription = null)
                Text("My Feedbacks", fontSize = 20.sp)
            }
            HorizontalDivider()
            Button(
                onClick = { },
                colors = ButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
                Text("Тестирование", fontSize = 20.sp)
            }
            HorizontalDivider()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserProfileScreenPreview() {
    ProgrammingMaterialsTheme {
        UserProfileScreen(rememberNavController())
    }
}
