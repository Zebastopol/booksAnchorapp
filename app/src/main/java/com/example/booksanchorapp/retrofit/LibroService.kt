package com.example.booksanchorapp.retrofit

import com.example.booksanchorapp.modelo.Libro
import com.example.booksanchorapp.modelo.LibroItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LibroService {

    @GET("books")
    fun listLibros(): Call<List<LibroItem>>

    @GET("bookDetail/{id}")
    fun detailBook(@Path("id") libroId: Int) : Call<LibroItem>
}