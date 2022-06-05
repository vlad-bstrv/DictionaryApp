package com.vladbstrv.dictionaryapp

import android.app.Application
import android.content.Context
import com.vladbstrv.dictionaryapp.data.retrofit.RetrofitRepositoryImpl
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository

private const val URL = "https://dictionary.skyeng.ru/api/public/v1/"
class App : Application() {
    val wordsRepo: WordsRepository by lazy { RetrofitRepositoryImpl(URL) }
}

val Context.app: App
    get() = applicationContext as App