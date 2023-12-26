package com.walletmix.randomquotesssot.data

import com.walletmix.randomquotesssot.data.model.RandomQuote
import kotlinx.coroutines.flow.Flow

interface RandomQuotesRepository {
    fun getRandomQuotes(): Flow<List<RandomQuote>>

    fun fetchRandomQuotes(): Flow<Result<RandomQuote>>
}