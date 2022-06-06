package com.vladbstrv.dictionaryapp.di

import com.vladbstrv.dictionaryapp.domain.repositories.WordsRepository
import com.vladbstrv.dictionaryapp.ui.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainActivityViewModelFactory(repository: WordsRepository) : MainActivityViewModelFactory {
        return MainActivityViewModelFactory(repository = repository)
    }
}