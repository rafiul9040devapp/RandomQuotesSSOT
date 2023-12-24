package com.walletmix.randomquotesssot.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.walletmix.randomquotesssot.data.local.RandomQuotesDao
import com.walletmix.randomquotesssot.data.local.RandomQuotesDatabase
import com.walletmix.randomquotesssot.data.local.RandomQuotesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext appContext: Context): RandomQuotesDatabase =
        Room.databaseBuilder(
            appContext,
            RandomQuotesDatabase::class.java,
            RandomQuotesDb
        ).build()

    @Provides
    fun providesRandomQuotesDao(randomQuotesDatabase: RandomQuotesDatabase): RandomQuotesDao =
        randomQuotesDatabase.randomQuotesDao()
}