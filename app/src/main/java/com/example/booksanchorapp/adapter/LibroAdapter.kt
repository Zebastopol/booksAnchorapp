package com.example.booksanchorapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booksanchorapp.R
import com.example.booksanchorapp.databinding.LibroItemBinding
import com.example.booksanchorapp.modelo.LibroItem
import com.squareup.picasso.Picasso

class LibroAdapter (private val datos:List<LibroItem>): RecyclerView.Adapter<LibroAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView: ImageView
        val lbTitulo:TextView
        val lbAutor:TextView
        val lbPais:TextView
        val lbLenguaje: TextView

        init {
            imageView = view.findViewById(R.id.imageView)
            lbTitulo = view.findViewById(R.id.lbTitulo)
            lbAutor = view.findViewById(R.id.lbAutor)
            lbPais = view.findViewById(R.id.lbPais)
            lbLenguaje = view.findViewById(R.id.lbLenguaje)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.libro_item, parent, false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val libro = datos.get(position)
            holder.lbTitulo.text = libro.titulo
            holder.lbAutor.text = libro.autor
            holder.lbPais.text = libro.pais
            holder.lbLenguaje.text = libro.lenguaje
            Picasso.get().load(libro.imagen).into(holder.imageView)


    }

    override fun getItemCount(): Int {
            return datos.size
    }
}