package com.vladbstrv.dictionaryapp

import android.app.Application
import android.content.Context
import com.vladbstrv.dictionaryapp.di.AppComponent
import com.vladbstrv.dictionaryapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}

val Context.app: App
    get() = applicationContext as App