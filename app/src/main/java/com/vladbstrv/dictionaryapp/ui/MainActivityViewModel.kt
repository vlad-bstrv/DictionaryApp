package com.vladbstrv.dictionaryapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladbstrv.dictionaryapp.domain.entities.WordData
import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel(val repository: WordsRepository) : MainActivityViewModelContract.ViewModel() {

    override val data: MutableLiveData<List<WordData>> = MutableLiveData<List<WordData>>()
    override val inProgress: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getTranslateWord(word: String) {
        inProgress.postValue(true)
        repository.getData(word)
        compositeDisposable.add(
            repository
                .getData(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy{
                    inProgress.postValue(false)
                    data.postValue(it)
                }
        )
    }
}