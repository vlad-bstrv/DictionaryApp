package com.vladbstrv.dictionaryapp.ui

import com.vladbstrv.dictionaryapp.domain.entities.WordData

class MainActivityContract {

    interface View {
        fun setSuccess(words: List<WordData>)
        fun setError(error: String)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()
        fun getTranslateWord(word: String)
    }
}