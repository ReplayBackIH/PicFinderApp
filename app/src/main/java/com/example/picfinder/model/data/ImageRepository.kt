package com.example.picfinder.model.data

import com.example.picfinder.model.data.api.ApiService
import java.lang.Exception

class ImageRepository(private val apiService: ApiService) {

    suspend fun getImages(apiKey: String, userRequest: String): List<Image> {
        return try {
            val response = apiService.getImages(
                apiKey = apiKey,
                userRequest = userRequest
            )
            response.listOfImages ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
