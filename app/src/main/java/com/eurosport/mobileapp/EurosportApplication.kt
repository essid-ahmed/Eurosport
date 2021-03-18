package com.eurosport.mobileapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EurosportApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}