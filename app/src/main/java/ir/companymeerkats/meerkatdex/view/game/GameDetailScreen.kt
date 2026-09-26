package ir.companymeerkats.meerkatdex.view.game


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    gameId: Long,
    onBackClick: () -> Unit,
    viewModel: GameViewModel = hiltViewModel()
) {

    val gameState by viewModel.gameIdState.collectAsStateWithLifecycle()

    LaunchedEffect(gameId) {
        viewModel.getGameById(gameId)
    }

    val scrollBehavior =
        androidx.compose.material3.TopAppBarDefaults
            .exitUntilCollapsedScrollBehavior()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            )
    ) {

        GameDetailTopBar(
            scrollBehavior = scrollBehavior,
            onBackClick = onBackClick
        )

        when (val state = gameState) {

            is UiState.Loading -> {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Error -> {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Timber.tag("@testErrorDetail").e(state.message)
                    Text(
                        text = state.message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            is UiState.Success -> {
                Timber.tag("@testSuccess").e(state.data.toString())
                GameDetailContent(
                    game = state.data
                )
            }
        }
    }
}