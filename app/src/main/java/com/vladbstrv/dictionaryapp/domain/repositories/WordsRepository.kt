package com.vladbstrv.dictionaryapp.domain.repositories

import com.vladbstrv.dictionaryapp.domain.entities.WordData

interface WordsRepository {

    suspend fun getData(word: String): List<WordData>
}