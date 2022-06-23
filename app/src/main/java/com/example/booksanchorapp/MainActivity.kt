package com.example.booksanchorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksanchorapp.adapter.LibroAdapter
import com.example.booksanchorapp.databinding.ActivityMainBinding
import com.example.booksanchorapp.modelo.LibroItem
import com.example.booksanchorapp.retrofit.LibroService
import com.example.booksanchorapp.view.LibroViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val libroViewModel: LibroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        libroViewModel.cargarLibros()

        libroViewModel.libros.observe(this,  androidx.lifecycle.Observer{ libros ->
            binding.recyclerView.adapter = LibroAdapter(libros)
        })
    }
}