package com.example.booksanchorapp.retrofit

import com.example.booksanchorapp.modelo.LibroItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LibroService {

    @GET("books")
    suspend fun listLibros(): Response<List<LibroItem>>

    @GET("bookDetail/{id}")
    suspend fun detailBook(@Path("id") libroId: Int) : Response<LibroItem>
}