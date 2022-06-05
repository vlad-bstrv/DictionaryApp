package com.vladbstrv.dictionaryapp.ui

import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityPresenter(val repository: WordsRepository) : MainActivityContract.Presenter{
    private var view: MainActivityContract.View? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onAttach(view: MainActivityContract.View) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun getTranslateWord(word: String) {
        view?.showProgress()
        repository.getData(word)
        compositeDisposable.add(
            repository
                .getData(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.hideProgress()
                    view?.setSuccess(it)
                },{
                    view?.hideProgress()
                    view?.setError(it.message.toString())
                })
        )
    }


}