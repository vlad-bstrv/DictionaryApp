package com.vladbstrv.dictionaryapp.data.dto

import com.google.gson.annotations.SerializedName

private const val TEXT = "text"
private const val MEANINGS = "meanings"
private const val TRANSLATION = "translation"

data class WordDto(
    @SerializedName(TEXT)
    val text: String,

    @SerializedName(MEANINGS)
    val meanings: List<Meanings>
)

class Meanings(
    @SerializedName(TRANSLATION) val translation: Translation,
)

class Translation(@SerializedName(TEXT) val translation: String)
