package com.example.booksanchorapp.modelo

import com.google.gson.annotations.SerializedName

class Libro : ArrayList<LibroItem>()

data class LibroItem(

    val id: Int,
    @SerializedName("author")
    val autor:String,
    @SerializedName("country") val pais:String,
    @SerializedName("imageLink") val imagen:String,
    @SerializedName("language") val lenguaje:String,
    @SerializedName("link") val enlace:String,
    @SerializedName("pages") val paginas:Int,
    @SerializedName("title") val titulo:String,
    @SerializedName("year") val anno:Int,
    @SerializedName("price") val precio:Int,
    @SerializedName("lastPrice") val precioFinal:Int,
    @SerializedName("delivery") val despacho:Boolean  )

   /* @SerializedName("author") val author: String,
    @SerializedName("country") val country: String,
    @SerializedName("delivery") val delivery: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("imageLink") val imageLink: String,
    @SerializedName("language") val language: String,
    @SerializedName("lastPrice") val lastPrice: Int,
    @SerializedName("link")  val link: String,
    @SerializedName("pages") val pages: Int,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String,
    @SerializedName("year")  val year: Int

    */
