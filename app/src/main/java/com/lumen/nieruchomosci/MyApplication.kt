package com.lumen.nieruchomosci

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        print("Hello from Source-tree")
    }
}