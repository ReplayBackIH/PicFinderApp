package com.example.picfinder.data

data class SingleImage(
    val thumbnailImageUrl : String,
    val largeImageUrl : String,
    val tags : String,
    val userName : String,
    val likesNumber: Int,
    val downloadsNumber : Int,
    val commentsNumber : Int
)


