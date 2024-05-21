package com.example.picfinder.model.data

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("previewURL") val imageThumbnail : String,
    @SerializedName("user") val userName : String,
    @SerializedName("tags") val  imageTags: String,
    @SerializedName("largeImageURL") val largeImage: String,
    @SerializedName("likes") val  likes: Int,
    @SerializedName("downloads") val  numberOfDownloads: Int,
    @SerializedName("comments") val  numberOfComments: Int,

)


