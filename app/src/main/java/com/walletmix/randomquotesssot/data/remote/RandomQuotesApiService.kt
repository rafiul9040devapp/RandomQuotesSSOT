package com.walletmix.randomquotesssot.data.remote

import com.walletmix.randomquotesssot.data.model.RandomQuoteResponse
import com.walletmix.randomquotesssot.utils.RandomQuotePath
import retrofit2.Response
import retrofit2.http.GET



interface RandomQuotesApiService {

    @GET(RandomQuotePath)
    suspend fun getRandomQuotes(): Response<List<RandomQuoteResponse>>
}