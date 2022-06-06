package com.vladbstrv.dictionaryapp.di

import com.vladbstrv.dictionaryapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppNetworkModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}