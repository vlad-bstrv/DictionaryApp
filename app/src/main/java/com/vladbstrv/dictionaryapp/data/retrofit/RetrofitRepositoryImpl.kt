package com.vladbstrv.dictionaryapp.data.retrofit

import com.vladbstrv.dictionaryapp.data.mapper.Mapper
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepositoryImpl(private val url: String): WordsRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: DictionaryApi = retrofit.create(DictionaryApi::class.java)


    override fun getData(word: String): Single<List<WordData>> {
        return api.search(word).map {
            Mapper().mapWordDtoToEntity(it) }
    }
}