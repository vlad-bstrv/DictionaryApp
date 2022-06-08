package com.vladbstrv.dictionaryapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vladbstrv.dictionaryapp.data.retrofit.DictionaryApi
import com.vladbstrv.dictionaryapp.data.retrofit.RetrofitRepositoryImpl
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import com.vladbstrv.dictionaryapp.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "api_url"

val appModule = module {
    single<WordsRepository> { RetrofitRepositoryImpl(api = get()) }
    single<DictionaryApi> { get<Retrofit>().create(DictionaryApi::class.java)}
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named(API_URL)))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }
    single(named(API_URL)) { "https://dictionary.skyeng.ru/api/public/v1/" }

    viewModel { MainActivityViewModel(repository =  get()) }
}