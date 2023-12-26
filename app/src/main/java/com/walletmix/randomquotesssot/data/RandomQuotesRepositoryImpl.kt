package com.walletmix.randomquotesssot.data

import com.walletmix.randomquotesssot.data.local.RandomQuotesLocalDataSource
import com.walletmix.randomquotesssot.data.model.RandomQuote
import com.walletmix.randomquotesssot.data.model.toRandomQuote
import com.walletmix.randomquotesssot.data.model.toRandomQuoteEntity
import com.walletmix.randomquotesssot.data.remote.RandomQuotesRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomQuotesRepositoryImpl @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val localDataSource: RandomQuotesLocalDataSource,
    private val remoteDataSource: RandomQuotesRemoteDataSource
) : RandomQuotesRepository {

    override fun getRandomQuotes(): Flow<List<RandomQuote>> {
        return localDataSource.getRandomQuotes().map { localData ->
            localData.map { it.toRandomQuote() }
        }
    }

    override fun fetchRandomQuotes(): Flow<Result<RandomQuote>> = flow {

        try {
            val randomQuoteResponse = remoteDataSource.fetchRandomQuotes()
            if (randomQuoteResponse.isSuccess) {
                val randomQuotesEntity = randomQuoteResponse.getOrThrow().toRandomQuoteEntity()
                localDataSource.insertRandomQuotes(randomQuotesEntity)
                emit(randomQuoteResponse.map { it.toRandomQuote() })
            }
        } catch (exception: Exception) {
            emit(Result.failure(exception))
        }
    }.flowOn(coroutineDispatcher)

}