package com.example.booksanchorapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booksanchorapp.Detalle
import com.example.booksanchorapp.R
import com.example.booksanchorapp.databinding.LibroItemBinding
import com.example.booksanchorapp.modelo.LibroI
import com.example.booksanchorapp.modelo.LibroItem
import com.squareup.picasso.Picasso

const val LIBROID_MESSAGE = "com.example.booksanchorapp.LIBROID"

class LibroAdapter (private val datos:List<LibroI>): RecyclerView.Adapter<LibroAdapter.ViewHolder>(){

    class ViewHolder(val binding: LibroItemBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = LibroItemBinding.inflate(LayoutInflater.from(parent.context), parent,  false)
            return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val libro = datos.get(position)
            with(holder.binding) {
                lbTitulo.text = libro.titulo
                lbAutor.text = "Autor: ${libro.autor}"
                lbPais.text = "País: ${libro.pais}"
                lbLenguaje.text = "Lenguaje: ${libro.lenguaje}"
                Picasso.get().load(libro.imagen).into(imageView)
            }
        // click over libro item
        holder.binding.root.setOnClickListener(View.OnClickListener{
            val intent = Intent(it.context, Detalle::class.java).apply {
                putExtra(LIBROID_MESSAGE, libro.id)
            }
            it.context.startActivity(intent)
        })


    }

    override fun getItemCount(): Int {
            return datos.size
    }
}