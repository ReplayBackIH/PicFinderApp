package com.example.picfinder.model.data.api

import com.example.picfinder.model.data.Image
import com.example.picfinder.model.data.Images
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/")
    suspend fun getImages(
        @Query("key") apiKey : String,
        @Query("q") userRequest : String,
        @Query("image_type") imageType: String = "all"
    ) : Images

    companion object {
        private const val BASE_URL = "https://pixabay.com"

        fun createRequest() : ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}