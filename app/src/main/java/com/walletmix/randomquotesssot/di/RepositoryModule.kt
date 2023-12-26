package com.walletmix.randomquotesssot.di

import com.walletmix.randomquotesssot.data.RandomQuotesRepository
import com.walletmix.randomquotesssot.data.RandomQuotesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideRandomQuotesRepositoryImpl(repository: RandomQuotesRepositoryImpl): RandomQuotesRepository
}