package com.walletmix.randomquotesssot.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.walletmix.randomquotesssot.data.local.converter.DateConverter
import com.walletmix.randomquotesssot.data.local.converter.ListToStringConverter
import com.walletmix.randomquotesssot.data.model.RandomQuoteEntity



@Database(
    entities = [RandomQuoteEntity::class], version = 1
)
@TypeConverters(DateConverter::class, ListToStringConverter::class)
abstract class RandomQuotesDatabase : RoomDatabase() {
    abstract fun randomQuotesDao(): RandomQuotesDao
}