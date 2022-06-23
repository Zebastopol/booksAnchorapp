package com.example.booksanchorapp.mapper

import com.example.booksanchorapp.db.LibroEntity
import com.example.booksanchorapp.modelo.LibroI

class LibroMapper {
    companion object{
        fun toEntity(libro: LibroI): LibroEntity {
            with(libro) {
                return LibroEntity(
                    id, autor, pais, imagen, lenguaje, enlace, paginas, titulo, anno, precio, precioFinal, despacho
                )
            }
        }
    }
}