package com.vladbstrv.dictionaryapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.dictionaryapp.domain.entities.WordData

interface MainActivityViewModelContract {
    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract val data: LiveData<List<WordData>>
        abstract val inProgress: LiveData<Boolean>

        abstract fun getTranslateWord(word: String)
    }
}