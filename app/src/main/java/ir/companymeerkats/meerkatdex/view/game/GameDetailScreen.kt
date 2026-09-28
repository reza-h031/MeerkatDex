package ir.companymeerkats.meerkatdex.view.game


import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import timber.log.Timber
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

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
    val context = LocalContext.current
    Scaffold(
        modifier= Modifier
            .fillMaxSize()
            .nestedScroll(
                scrollBehavior.nestedScrollConnection
            ),
        topBar = {
            GameDetailTopBar(
                scrollBehavior = scrollBehavior,
                onBackClick = onBackClick
            )
                 },
        floatingActionButton = {
            if (gameState is UiState.Success) {
                val gameWebsite = (gameState as UiState.Success).data.website

                if (gameWebsite.isNotBlank()) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 40.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(
                            onClick = {
                                openWebsite(
                                    context = context,
                                    url = gameWebsite
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 10.dp
                                ),
                            shape = RoundedCornerShape(14.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Default.OpenInNew,
                                contentDescription = null
                            )

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Text(
                                text = "Visit Official Website"
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        when (val state = gameState) {

            is UiState.Loading -> {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Error -> {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
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
                    game = state.data,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .nestedScroll(
//                scrollBehavior.nestedScrollConnection
//            )
//    ) {
//
//        GameDetailTopBar(
//            scrollBehavior = scrollBehavior,
//            onBackClick = onBackClick
//        )
//
//        when (val state = gameState) {
//
//            is UiState.Loading -> {
//
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator()
//                }
//            }
//
//            is UiState.Error -> {
//
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Timber.tag("@testErrorDetail").e(state.message)
//                    Text(
//                        text = state.message,
//                        color = MaterialTheme.colorScheme.error
//                    )
//                }
//            }
//
//            is UiState.Success -> {
//                Timber.tag("@testSuccess").e(state.data.toString())
//                GameDetailContent(
//                    game = state.data
//                )
//            }
//        }
//    }
}