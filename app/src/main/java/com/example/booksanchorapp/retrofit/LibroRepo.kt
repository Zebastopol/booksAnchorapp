package com.example.booksanchorapp.retrofit

import androidx.room.Room
import com.example.booksanchorapp.db.BaseDatos
import com.example.booksanchorapp.db.LibroDao
import com.example.booksanchorapp.mapper.LibroMapper
import com.example.booksanchorapp.modelo.LibroI
import com.example.booksanchorapp.modelo.LibroItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibroRepo (

    val libroService : LibroService,
    val libroDao : LibroDao
){
    /*init {
        //Retrofit
            val baseUrl = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
            val retrofit = Retrofit.Builder()
            .baseUrl( baseUrl )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        libroService = retrofit.create(LibroService::class.java)

        //LibroDao
        val db = Room.databaseBuilder(null,BaseDatos::class.java,"libros-bd").build()
        libroDao = db.libroDao()
    }*/

    suspend fun findById(id:Int):LibroI {
        return withContext(Dispatchers.IO) {
            val response = libroService.detailBook(id)
            if( response.isSuccessful) {
                val libro = response.body() ?:
            }else{

            }
        }
    }

    suspend fun findAll(): List<LibroI> {
        return withContext(Dispatchers.IO) {
            val response = libroService.listLibros()
            if( response.isSuccessful) {
                val libros = response.body() ?: emptyList()
                //borra cache pasada
                libroDao.deleteAll()
                //cachea datos en BD
                libros.forEach { libroModel ->
                    libroDao.insertAll( LibroMapper.toEntity(libroModel) )
                }

                libros
            }else{
                libroDao.getAll()
            }
        }
    }
}