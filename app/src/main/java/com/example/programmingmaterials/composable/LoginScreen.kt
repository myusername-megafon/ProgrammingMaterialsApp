package com.example.programmingmaterials.composable

import android.widget.ProgressBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.programmingmaterials.model.LoginState
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme
import com.example.programmingmaterials.viewmodel.LoginViewModel

@Composable
fun LoginScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val viewModel = viewModel<LoginViewModel>()
        val screenState = viewModel.state
        Box(modifier = Modifier.padding(innerPadding)) {
            LoginContent(
                screenState = screenState.value,
                onEditEmail = { newEmail -> viewModel.onEditEmail(newEmail) },
                onEditPassword = viewModel::onEditPassword,
                onButtonClick = { viewModel.onClickButton() }
            )
        }
    }
}

@Composable
private fun LoginContent(
    screenState: LoginState,
    onEditEmail: (String) -> Unit = {},
    onEditPassword: (String) -> Unit = {},
    onButtonClick: () -> Unit = {}
) {
    if (screenState.isProgress) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = screenState.emailText,
                label = { Text("Email") },
                onValueChange = onEditEmail
            )
            OutlinedTextField(
                visualTransformation = PasswordVisualTransformation(),
                value = screenState.passwordText,
                label = { Text("Password") },
                onValueChange = onEditPassword
            )
            Button(
                onClick = onButtonClick,
                content = { Text("Sign In") }
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun Preview() {
    ProgrammingMaterialsTheme {
        LoginContent(
            LoginState(
                emailText = "this is preview"
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewProgress() {
    ProgrammingMaterialsTheme {
        LoginContent(
            LoginState(
                isProgress = true
            )
        )
    }
}