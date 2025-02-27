package com.example.project26des.dependenciesinjection

import com.example.project26des.repository.MahasiswaRepository
import com.example.project26des.repository.NetworkMahasiswaRepository
import com.example.project26des.service.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val MahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {

    private val baseUrl = "http://10.0.2.2:8000/umyTI/" // localhost diganti ip kalau run di hp
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val mahasiswaService: MahasiswaService by lazy {
        retrofit.create(MahasiswaService::class.java)
    }

    override val MahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository(mahasiswaService)
    }
}
