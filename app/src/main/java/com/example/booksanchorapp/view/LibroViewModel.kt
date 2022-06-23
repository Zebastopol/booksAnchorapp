package com.example.booksanchorapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksanchorapp.app.AnchorBooksApp
import com.example.booksanchorapp.modelo.LibroI
import com.example.booksanchorapp.modelo.LibroItem
import com.example.booksanchorapp.retrofit.LibroRepo
import kotlinx.coroutines.launch

class LibroViewModel(application: Application): AndroidViewModel(application) {

        val libros = MutableLiveData<List<LibroI>>()

    fun cargarLibros() {
        viewModelScope.launch {
            val app = getApplication<AnchorBooksApp>()
            val repo = LibroRepo(app.libroService, app.libroDao)
            val librosFromRepo = repo.findAll()
            if( !librosFromRepo.isNullOrEmpty() ){
                libros.postValue(librosFromRepo)
            }
        }
    }
}