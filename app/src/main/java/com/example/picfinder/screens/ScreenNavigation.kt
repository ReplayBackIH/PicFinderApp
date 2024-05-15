package com.example.picfinder.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = ScreenRoutes.DetailedImageScreen.route){
            DetailedImageScreen(navController = navController)
        }
    }
}