package com.walletmix.randomquotesssot.ui

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.walletmix.randomquotesssot.data.model.RandomQuote
import com.walletmix.randomquotesssot.domain.FetchRandomQuotesUseCase
import com.walletmix.randomquotesssot.domain.GetRandomQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val fetchRandomQuotesUseCase: FetchRandomQuotesUseCase,
    private val getRandomQuotesUseCase: GetRandomQuotesUseCase
) : ViewModel() {

}

sealed class RandomQuotesUiState {
    data class Success(val quotes: List<RandomQuote>) : RandomQuotesUiState()
    data class Error(@StringRes val errorMessageId: Int) : RandomQuotesUiState()
    data object Loading : RandomQuotesUiState()
}