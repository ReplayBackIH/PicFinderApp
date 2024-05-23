package com.example.picfinder

import android.app.Application
import com.example.picfinder.model.data.database.AppDatabase

class MyApplication  : Application() {

    val database by lazy {
        AppDatabase.createDatabase(this)
    }

}