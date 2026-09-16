package ir.companymeerkats.meerkatdex.view.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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

@ExperimentalMaterial3Api
@Composable
fun SearchScreen (){
    var query by remember {
        mutableStateOf("")
    }
    val gridState= rememberLazyGridState()
//    val isScrolled =gridState.firstVisibleItemScrollOffset>0
    val scrollBehavior=TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Column (modifier = Modifier
        .fillMaxWidth()
        .nestedScroll(
            scrollBehavior.nestedScrollConnection
        )){
//        AnimatedVisibility(
//            visible = !isScrolled
//        ) {
//            SearchTopBar()
//        }
        SearchTopBar(scrollBehavior)
        CustomSearchBar(query = query,
            onQueryChange ={
                query = it
            })

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier=Modifier.fillMaxWidth()){
            item(20) {
                Text(text = "test")
//                gameCard
            }
        }
//        LazyVerticalGrid(columns = GridCells.Fixed(2),
//            state = gridState) {
//            item(
//                span = {
//                    GridItemSpan(maxLineSpan)
//                }){
//                CustomSearchBar(query = query,
//                    onQueryChange ={
//                        query = it
//                    } ,
//                    modifier = modifier)
//            }
//            items(games){
//                GameCard(game=it)
//            }
            // Game Grid
        }

    }