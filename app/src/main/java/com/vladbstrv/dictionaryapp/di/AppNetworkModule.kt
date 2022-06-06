package com.vladbstrv.dictionaryapp.di


import com.vladbstrv.dictionaryapp.data.retrofit.DictionaryApi
import com.vladbstrv.dictionaryapp.data.retrofit.RetrofitRepositoryImpl
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppNetworkModule {

    @Singleton
    @Provides
    fun provideDictionaryApi(retrofit: Retrofit): DictionaryApi {
        return retrofit.create(DictionaryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideWordsRepository(api: DictionaryApi): WordsRepository {
        return RetrofitRepositoryImpl(api)
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Named("api_url")
    fun provideBaseUrl(): String {
        return "https://dictionary.skyeng.ru/api/public/v1/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("api_url") baseUrl: String, factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(factory)
            .build()
    }
}