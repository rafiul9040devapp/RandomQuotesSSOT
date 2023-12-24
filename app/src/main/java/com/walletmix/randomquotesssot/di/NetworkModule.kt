package com.walletmix.randomquotesssot.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.walletmix.randomquotesssot.data.remote.RandomQuotesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


private const val BASE_URL = "https://api.quotable.io"

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideRandomQuoteApiService(retrofit: Retrofit): RandomQuotesApiService = retrofit.create()

    @Provides
    @Singleton
    fun getGson(): Gson = GsonBuilder().serializeNulls().setLenient().create()
}