package com.example.picfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picfinder.model.data.Image
import com.example.picfinder.model.data.ImageRepository
import com.example.picfinder.model.data.database.AppDatabase
import com.example.picfinder.model.data.database.ImageEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ImageViewModel(private val imageRepository : ImageRepository) : ViewModel(){

    private val _images = MutableStateFlow<List<Image>>(emptyList())
    val imageList : StateFlow<List<Image>> get() = _images

    fun searchImages(apiKey : String, userRequest : String){
        viewModelScope.launch {
            try {
                val images = imageRepository.getImages(
                    apiKey = apiKey,
                    userRequest = userRequest
                )
                _images.value = images
            }catch (e : Exception){
                throw IllegalArgumentException ("Error fetching images")
            }
        }
    }

    fun getImageById(imageId : Int) : StateFlow<ImageEntity?>{
        val image = MutableStateFlow<ImageEntity?>(null)
        viewModelScope.launch {
            image.value = imageRepository.getImageById(imageId = imageId)
        }
        return image
    }

}