package com.example.booksanchorapp.app

import android.app.Application
import androidx.room.Room
import com.example.booksanchorapp.db.BaseDatos
import com.example.booksanchorapp.retrofit.LibroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnchorBooksApp : Application() {

    val baseDatos by lazy {
        Room.databaseBuilder(
            this,
            BaseDatos::class.java,
            "libros-bd"
        ).build()
    }

    val libroDao by lazy { baseDatos.libroDao() }

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/Himuravidal/anchorBooks/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val libroService by lazy {retrofit.create(LibroService::class.java)}
}