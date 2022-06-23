package com.example.booksanchorapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.booksanchorapp.modelo.LibroI
import com.google.gson.annotations.SerializedName

@Entity(tableName= "libros")
data class LibroEntity(
    @PrimaryKey override val id:Int,
    override val autor:String,
    override val pais:String,
    override val imagen:String,
    override val lenguaje:String,
    override val enlace:String?,
    override val paginas:Int?,
    override val titulo:String,
    override val anno:Int?,
    override val precio:Int?,
    override val precioFinal:Int?,
    override val despacho:Boolean?

): LibroI
