package com.vladbstrv.dictionaryapp.data.retrofit

import com.vladbstrv.dictionaryapp.data.dto.WordDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryApi {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Single<List<WordDto>>
}