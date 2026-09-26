package ir.companymeerkats.meerkatdex.view.home.featuredGame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import ir.companymeerkats.meerkatdex.model.SimpleGame

@Composable
fun FeaturedGamesSection(
    modifier: Modifier = Modifier,
    featuredGames:List<SimpleGame>,
    onGameClick:(Long)-> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = {
            featuredGames.size
        }
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {


        // Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->

            val game = featuredGames[page]

            FeaturedGameCard(
                game = game,
                onClick={
                    onGameClick(game.id)
                }
            )
        }
        // Indicator
        PagerIndicator(
            pageCount = featuredGames.size,
            currentPage = pagerState.currentPage,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}