package com.walletmix.randomquotesssot.data.remote

import com.walletmix.randomquotesssot.data.model.RandomQuoteResponse
import retrofit2.Response
import retrofit2.http.GET

private const val RandomQuotePath = "quotes/random"

interface RandomQuotesApiService {

    @GET(RandomQuotePath)
    suspend fun getRandomQuotes(): Response<List<RandomQuoteResponse>>
}