package com.example.booksanchorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksanchorapp.adapter.LibroAdapter
import com.example.booksanchorapp.databinding.ActivityMainBinding
import com.example.booksanchorapp.modelo.Libro
import com.example.booksanchorapp.modelo.LibroItem
import com.example.booksanchorapp.retrofit.LibroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val baseUrl = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"
        val retrofit = Retrofit.Builder()
            .baseUrl( baseUrl )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val libroService = retrofit.create(LibroService::class.java)

       /* libroService.detailBook(3).enqueue(object : Callback<LibroItem>{
            override fun onResponse(call: Call<LibroItem>, response: Response<LibroItem>) {
                    val libro = response.body()
                    binding.textView1.text = libro.toString()
                    Log.d("RETROFIT","Cargando Datos del Libro")

            }

            override fun onFailure(call: Call<LibroItem>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("RETROFIT","Fallo al recuperar")
            }

        })*/

        libroService.listLibros().enqueue(object : Callback<List<LibroItem>>{
            override fun onResponse(call: Call<List<LibroItem>>, response: Response<List<LibroItem>>) {
                val libros = response.body() ?: listOf()
                recyclerView.adapter = LibroAdapter(libros)
                Log.d("RECYCLER","Cargando datos en el Adapter...")
                }

            override fun onFailure(call: Call<List<LibroItem>>, t: Throwable) {
                t.printStackTrace()
                Log.e("RETROFIT","Fallo al recuperar")
            }


        })
    }
}