package com.walletmix.randomquotesssot.data.local.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDate

class DateConverter {
    @TypeConverter
    fun localDateFromString(savedDate: String?): LocalDate? = savedDate?.toLocalDate()

    @TypeConverter
    fun localDateToString(localDate: LocalDate?): String = localDate.toString()
}
