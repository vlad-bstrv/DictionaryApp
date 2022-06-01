package com.vladbstrv.dictionaryapp.data.dto

import com.google.gson.annotations.SerializedName

data class WordDto(
    @SerializedName("text")
    val text: String,

    @SerializedName("meanings")
    val meanings: List<Meanings>
)

class Meanings(
    @field:SerializedName("translation") val translation: Translation,
)

class Translation(@field:SerializedName("text") val translation: String)
