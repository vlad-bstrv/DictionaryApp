package com.vladbstrv.dictionaryapp.domain.repositories

import io.reactivex.Single

interface WordsRepository<T> {

    fun getData(word: String): Single<T>
}