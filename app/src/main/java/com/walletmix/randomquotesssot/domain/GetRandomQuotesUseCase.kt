package com.walletmix.randomquotesssot.domain

import com.walletmix.randomquotesssot.data.RandomQuotesRepository
import com.walletmix.randomquotesssot.data.model.RandomQuoteResponse
import javax.inject.Inject

class GetRandomQuotesUseCase @Inject constructor(
    private val repository: RandomQuotesRepository
) {
    operator fun invoke() = repository.getRandomQuotes()
}