package com.vladbstrv.dictionaryapp.domain.repositories

import com.vladbstrv.dictionaryapp.domain.entities.WordData
import io.reactivex.rxjava3.core.Single


interface WordsRepository {

    fun getData(word: String): Single<List<WordData>>
}