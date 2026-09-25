package ir.companymeerkats.meerkatdex.view.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.state.UiState

@ExperimentalMaterial3Api
@Composable
fun SearchScreen (
    onBackClick:()-> Unit,
    viewModel: GameViewModel = hiltViewModel(),
    listDataSimpleTest:List<SimpleGame>
){
    var query by remember {
        mutableStateOf("")
    }
    val gameFilterState by viewModel.gameFilterState
        .collectAsStateWithLifecycle()
    val scrollBehavior=TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Column (modifier = Modifier
        .fillMaxWidth()
        .nestedScroll(
            scrollBehavior.nestedScrollConnection
        )){
        SearchTopBar(
            scrollBehavior,
            onBackClick)
        CustomSearchBar(query = query,
            onQueryChange ={
                query = it
            },
            onSearch = {
                val text = query.trim()

                if (text.isNotEmpty()) {
                    viewModel.gameGamesFilter(text)
                }
            })
        Spacer(
            modifier = Modifier.height(16.dp)
        )
//        when (val state = gameFilterState) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            items = listDataSimpleTest,
                            key = { game -> game.id }
                        ) { game ->

                            GameCardSearch(
                                game,
                                onClick = {},
                                )
                        }
                    }
//            UiState.Loading -> {
//                CircularProgressIndicator()
//            }
//
//            is UiState.Success -> {
//
//                if (state.data.isEmpty()) {
//
//                    Text(
//                        text = "No games found"
//                    )
//
//                } else {
//
//                    LazyColumn(
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        items(
//                            items = state.data,
//                            key = { game -> game.id }
//                        ) { game ->
//
//                            Text(
//                                text = game.name
//                            )
//                        }
//                    }
//                }
//            }
//
//            is UiState.Error -> {
//
//                Text(
//                    text = state.message
//                )
//            }
//        }
    }
}