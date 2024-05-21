package com.example.picfinder.view.navigation

sealed class ScreenRoutes(val route: String) {
     object MainScreen : ScreenRoutes("main_screen")
     object DetailedImageScreen : ScreenRoutes("detailed_image_screen")
}