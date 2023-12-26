package com.walletmix.randomquotesssot.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.walletmix.randomquotesssot.data.model.RandomQuoteEntity
import com.walletmix.randomquotesssot.utils.RandomQuotesTable
import kotlinx.coroutines.flow.Flow


@Dao
interface RandomQuotesDao {
    @Query("SELECT * FROM $RandomQuotesTable")
    fun getAllRandomQuotes(): Flow<List<RandomQuoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRandomQuotes(randomQuote: RandomQuoteEntity)
}