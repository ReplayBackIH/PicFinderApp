package com.example.picfinder.model.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImages(images: List<ImageEntity>)

    @Query("SELECT * FROM images")
    suspend fun getAllImages(): List<ImageEntity>

    @Query("DELETE FROM images")
    suspend fun deleteAllImages()

    @Query("SELECT * FROM images WHERE id = :imageId LIMIT 1")
    suspend fun getImageById(imageId: Int): ImageEntity?
}