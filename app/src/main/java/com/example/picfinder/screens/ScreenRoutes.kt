package com.example.picfinder.screens

sealed class ScreenRoutes(val route: String) {
     object MainScreen : ScreenRoutes("main_screen")
     object DetailedImageScreen : ScreenRoutes("detailed_image_screen")
}