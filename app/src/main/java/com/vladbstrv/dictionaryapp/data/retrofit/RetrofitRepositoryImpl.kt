package com.vladbstrv.dictionaryapp.data.retrofit

import com.vladbstrv.dictionaryapp.data.mapper.Mapper
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import io.reactivex.rxjava3.core.Single

class RetrofitRepositoryImpl(private val api: DictionaryApi): WordsRepository {

    override fun getData(word: String): Single<List<WordData>> {
        return api.search(word).map {
            Mapper().mapWordDtoToEntity(it) }
    }
}