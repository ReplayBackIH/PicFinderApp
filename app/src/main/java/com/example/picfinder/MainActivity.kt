package com.example.picfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.picfinder.model.data.ImageRepository
import com.example.picfinder.model.data.api.ApiService
import com.example.picfinder.view.navigation.Navigation
import com.example.picfinder.ui.theme.PicFinderTheme
import com.example.picfinder.viewmodel.ImageViewModel
import com.example.picfinder.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    private val imageViewModel : ImageViewModel by viewModels {
        ViewModelFactory(ImageRepository(ApiService.createRequest()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicFinderTheme {
                Navigation(imageViewModel)
            }
        }
    }
}
