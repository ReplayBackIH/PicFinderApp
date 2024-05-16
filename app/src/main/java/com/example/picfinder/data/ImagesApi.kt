package com.example.picfinder.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("/api/")
    suspend fun getImages(
        @Query("key") apiKey : String,
        @Query("q") userRequest : String
    ) : Images

    companion object {
        private const val BASE_URL = "https://pixabay.com"

        fun createRequest() : ImagesApi{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ImagesApi::class.java)
        }
    }
}