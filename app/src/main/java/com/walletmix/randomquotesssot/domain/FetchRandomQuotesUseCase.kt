package com.walletmix.randomquotesssot.domain

import com.walletmix.randomquotesssot.data.RandomQuotesRepository
import javax.inject.Inject

class FetchRandomQuotesUseCase @Inject constructor(
    private val repository: RandomQuotesRepository
) {
    operator fun invoke() = repository.fetchRandomQuotes()
}