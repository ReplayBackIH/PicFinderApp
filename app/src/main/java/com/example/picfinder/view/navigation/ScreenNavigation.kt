package com.example.picfinder.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.picfinder.view.screens.DetailedImageScreen
import com.example.picfinder.view.screens.ImageSearchScreen
import com.example.picfinder.viewmodel.ImageViewModel

@Composable
fun Navigation(imageViewModel: ImageViewModel) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route) {
            ImageSearchScreen(navController = navController, imageViewModel = imageViewModel)
        }
        composable(route = ScreenRoutes.DetailedImageScreen.route){
            DetailedImageScreen(navController = navController)
        }
    }
}