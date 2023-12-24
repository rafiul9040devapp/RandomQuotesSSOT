package com.walletmix.randomquotesssot.data.remote

import com.walletmix.randomquotesssot.data.model.RandomQuoteResponse
import okhttp3.ResponseBody
import okio.IOException
import javax.inject.Inject

class RandomQuotesRemoteDataSource @Inject constructor(
    private val randomQuotesApiService: RandomQuotesApiService
) {
    suspend fun fetchRandomQuotes(): Result<RandomQuoteResponse> {
        val response = randomQuotesApiService.getRandomQuotes()
        if (response.isSuccessful) {
            return response.body()?.first()?.let { Result.success(it) } ?: Result.failure(
                IOException("No Data Received")
            )
        }
        val error: ResponseBody? = response.errorBody()
        return Result.failure(IOException(error.toString()))
    }
}