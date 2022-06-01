package com.vladbstrv.dictionaryapp.domain.repositories

import com.vladbstrv.dictionaryapp.domain.entities.WordData
import io.reactivex.Observable

interface WordsRepository<T> {

    fun getData(word: String): Observable<T>
}