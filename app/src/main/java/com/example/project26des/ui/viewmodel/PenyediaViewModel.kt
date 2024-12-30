package com.example.project26des.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.project26des.MahasiswaApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.MahasiswaRepository) }
        initializer { InsertViewModel(aplikasiMahasiswa().container.MahasiswaRepository) }
        initializer { DetailViewModel(aplikasiMahasiswa().container.MahasiswaRepository) }
        initializer { UpdateViewModel(createSavedStateHandle(),aplikasiMahasiswa().container.MahasiswaRepository) }
    }
}

fun CreationExtras.aplikasiMahasiswa(): MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)