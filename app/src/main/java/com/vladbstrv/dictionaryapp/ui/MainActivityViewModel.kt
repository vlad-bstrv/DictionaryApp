package com.vladbstrv.dictionaryapp.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityViewModel(val repository: WordsRepository) : MainActivityViewModelContract.ViewModel() {

    override val data: MutableLiveData<List<WordData>> = MutableLiveData<List<WordData>>()
    override val inProgress: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    override fun getTranslateWord(word: String) {
        inProgress.postValue(true)

        viewModelScope.launch {
            inProgress.postValue(false)
            data.postValue(repository.getData(word))
        }
    }
}