package com.example.picfinder.model.data

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("hits") val listOfImages : List<Image>
)
