package com.vladbstrv.dictionaryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository

class MainActivityViewModelFactory(
    val repository: WordsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(
            repository = repository
        ) as T
    }
}