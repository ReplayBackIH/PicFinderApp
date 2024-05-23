package com.example.picfinder.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.picfinder.view.screens.DetailedImageScreen
import com.example.picfinder.view.screens.SearchScreen
import com.example.picfinder.viewmodel.ImageViewModel

@Composable
fun Navigation(imageViewModel: ImageViewModel) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.MainScreen.route
    ) {
        composable(route = ScreenRoutes.MainScreen.route) {
            SearchScreen(navController = navController, imageViewModel = imageViewModel)
        }
        composable(
            route = ScreenRoutes.DetailedImageScreen.route + "/{imageId}",
            arguments = listOf(navArgument("imageId") {type = NavType.IntType})
            ){backStackEntry ->
            val imageId = backStackEntry.arguments?.getInt("imageId") ?: return@composable
            DetailedImageScreen(imageId = imageId,navController = navController,imageViewModel = imageViewModel)
        }
    }
}