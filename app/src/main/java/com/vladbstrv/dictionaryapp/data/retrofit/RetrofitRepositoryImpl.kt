package com.vladbstrv.dictionaryapp.data.retrofit

import com.vladbstrv.dictionaryapp.data.mapper.Mapper
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository

class RetrofitRepositoryImpl(private val api: DictionaryApi): WordsRepository {

    override suspend fun getData(word: String): List<WordData> {
        return Mapper().mapWordDtoToEntity(api.searchAsync(word).await())
    }
}