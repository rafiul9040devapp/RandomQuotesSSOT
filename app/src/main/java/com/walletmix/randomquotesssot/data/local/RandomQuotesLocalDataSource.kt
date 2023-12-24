package com.walletmix.randomquotesssot.data.local

import com.walletmix.randomquotesssot.data.model.RandomQuoteEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomQuotesLocalDataSource @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val randomQuotesDao: RandomQuotesDao
) {

    suspend fun insertRandomQuotes(randomQuoteEntity: RandomQuoteEntity) {
        withContext(coroutineDispatcher) {
            randomQuotesDao.insertRandomQuotes(randomQuoteEntity)
        }
    }

    fun getRandomQuotes() = randomQuotesDao.getAllRandomQuotes()

}