package com.example.project26des

import android.app.Application
import com.example.project26des.dependenciesinjection.MahasiswaContainer


class MahasiswaApp : Application() {
    lateinit var container: MahasiswaContainer

    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}

