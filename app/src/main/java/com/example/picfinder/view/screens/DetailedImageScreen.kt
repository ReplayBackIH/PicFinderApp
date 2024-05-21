package com.example.picfinder.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.picfinder.view.navigation.ScreenRoutes

@Composable
fun DetailedImageScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Detailed Screen")
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(ScreenRoutes.MainScreen.route) {
                popUpTo(ScreenRoutes.MainScreen.route) {
                    inclusive = true
                }
            }
        }
        ) {
            Text(text = "Go Back")
        }
    }
}