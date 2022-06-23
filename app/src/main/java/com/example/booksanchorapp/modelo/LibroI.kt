package com.example.booksanchorapp.modelo


interface LibroI {

    val id: Int
    val autor: String
    val pais: String
    val imagen: String
    val lenguaje: String
    val enlace: String?
    val paginas: Int?
    val titulo: String
    val anno: Int?
    val precio: Int?
    val precioFinal: Int?
    val despacho: Boolean?
}