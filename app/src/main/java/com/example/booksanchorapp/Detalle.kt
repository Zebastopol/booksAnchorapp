package com.example.booksanchorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booksanchorapp.adapter.LIBROID_MESSAGE
import com.example.booksanchorapp.databinding.ActivityDetalleBinding

class Detalle : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val libroid = intent.getIntExtra(LIBROID_MESSAGE,0)

        binding.textView.text = "$libroid"
    }
}