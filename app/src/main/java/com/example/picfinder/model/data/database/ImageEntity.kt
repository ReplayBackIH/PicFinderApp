package com.example.picfinder.model.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey
    val id : Int,

    val imageThumbnail : String,
    val userName : String,
    val imageTags : String,
    val largeImage : String,
    val likes : Int,
    val numberOfDownloads: Int,
    val numberOfComments: Int

)
