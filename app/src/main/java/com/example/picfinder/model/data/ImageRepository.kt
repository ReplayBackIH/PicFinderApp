package com.example.picfinder.model.data

import com.example.picfinder.model.data.api.ApiService
import com.example.picfinder.model.data.database.AppDatabase
import com.example.picfinder.model.data.database.ImageEntity
import java.lang.Exception

class ImageRepository(private val apiService: ApiService, private val database: AppDatabase) {

    suspend fun getImages(apiKey: String, userRequest: String): List<Image> {
        return try {
            val response = apiService.getImages(
                apiKey = apiKey,
                userRequest = userRequest
            )
            val imagesForEntity = response.listOfImages.map {image ->
                ImageEntity(
                    id = image.imageId,
                    imageThumbnail = image.imageThumbnail,
                    userName = image.userName,
                    imageTags = image.imageTags,
                    largeImage = image.largeImage,
                    likes = image.likes,
                    numberOfDownloads = image.numberOfDownloads,
                    numberOfComments = image.numberOfComments
                )
            }
            database.dao.deleteAllImages()
            database.dao.insertAllImages(imagesForEntity)
            response.listOfImages
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getImageById(imageId : Int) : ImageEntity?{
        return database.dao.getImageById(imageId)
    }
}
