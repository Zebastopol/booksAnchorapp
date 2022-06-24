package com.example.booksanchorapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.booksanchorapp.adapter.LIBROID_MESSAGE
import com.example.booksanchorapp.databinding.ActivityDetalleBinding
import com.example.booksanchorapp.view.LibroDetalleViewModel
import com.squareup.picasso.Picasso

class Detalle : AppCompatActivity() {


    private lateinit var binding: ActivityDetalleBinding

    private val libroDetalleViewModel: LibroDetalleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val libroid = intent.getIntExtra(LIBROID_MESSAGE,0)
        //delegada la responsabilidad al ViewModel
        //para que cargue los datos del libro
        libroDetalleViewModel.cargarLibro(libroid)

        libroDetalleViewModel.libro.observe(this, Observer { libro ->
            with(binding){
                textView.text  = libro.titulo
                textView2.text = libro.autor
                textView3.text = "${libro.precio}"
                Picasso.get().load(libro.imagen).into(imageView3)
            }

            binding.button.setOnClickListener {
                val textoCorreo = """
                    Hola, 
                    Acabo de ver el libro ${libro.titulo} de código ${libro.id} y me gustaría que
                    me contactaran a este correo o al siguiente número telefónico: ______________
                """

                    .trimIndent()

                val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                    type = "msage/rfc822" // fix para que funcione PARA (TO)
                    data = Uri.parse("mailto: ")
                    val para:Array<String> = arrayOf("ventas@anchorbook.cl")
                    putExtra(Intent.EXTRA_EMAIL, para)
                    putExtra(Intent.EXTRA_SUBJECT, "Consulta por Título ${libro.titulo} de código ${libro.id} a la venta")
                    putExtra(Intent.EXTRA_TEXT, textoCorreo)
                }
                startActivity(intentMail)
            }

        })
    }
}