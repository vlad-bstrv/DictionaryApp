package com.vladbstrv.dictionaryapp.data.mapper

import com.vladbstrv.dictionaryapp.data.dto.WordDto
import com.vladbstrv.dictionaryapp.domain.entities.WordData

class Mapper {

    fun mapWordDtoToEntity(wordDto: List<WordDto>):List<WordData> {
        val list: MutableList<WordData> = mutableListOf()

        for (word in wordDto) {
            list.add(
                WordData(
                    text = word.text,
                    translate = word.meanings[0].translation.translation
                )
            )
        }
        return list
    }
}