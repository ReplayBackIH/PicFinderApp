package com.example.picfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.picfinder.model.data.ImageRepository

class ViewModelFactory(private val imageRepository: ImageRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ImageViewModel(imageRepository) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}