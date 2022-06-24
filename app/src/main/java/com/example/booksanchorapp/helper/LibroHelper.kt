package com.example.booksanchorapp.helper

import com.example.booksanchorapp.modelo.LibroItem

class LibroHelper {
    companion object {
        fun emptyLibroModel(): LibroItem{
            return LibroItem(
                0,
                "Sin info",
                "",
                "",
                "",
                "",
                0,
                "",
                0,
                0,
                0,
                true

            )

        }
    }
}