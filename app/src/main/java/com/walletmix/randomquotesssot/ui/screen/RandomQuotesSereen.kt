package com.walletmix.randomquotesssot.ui.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.walletmix.randomquotesssot.R
import com.walletmix.randomquotesssot.ui.Dimensions
import com.walletmix.randomquotesssot.ui.QuotesViewModel
import com.walletmix.randomquotesssot.ui.RandomQuotesUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomQuotesScreen(
    modifier: Modifier = Modifier,
    viewModel: QuotesViewModel = hiltViewModel()
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val uiState = viewModel.quotesUiState.collectAsState().value
    val snackBarHostState = remember { SnackbarHostState() }

    val onErrorAction: (String) -> Unit = { message ->
        coroutineScope.launch {
            snackBarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Long
            )
        }
    }

    val onFabClick = {
        viewModel.fetchRandomQuotes()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.padding(Dimensions.One),
                        style = MaterialTheme.typography.displayMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            )
        },

        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onFabClick,
                text = { Text(text = "New Quotes") },
                icon = {
                    Icon(
                        Icons.Filled.Add,
                        stringResource(id = R.string.add_new_quote_button)
                    )
                }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        modifier = modifier
    ) { paddingValues ->
        RandomQuotesContent(
            uiState = uiState,
            onErrorAction = onErrorAction,
            paddingValues = paddingValues
        )

    }

}

@Composable
fun RandomQuotesContent(
    uiState: RandomQuotesUiState,
    onErrorAction: (String) -> Unit,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    TODO("Not yet implemented")
}
