package ir.companymeerkats.meerkatdex.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.view.home.featuredGame.FeaturedGamesSection
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.view.home.gameSection.GameSection
import ir.companymeerkats.meerkatdex.view.search.CustomSearchBar

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    onMenuClick:() -> Unit,
    onGameClick: (Long) -> Unit,
    onSearchClick: () -> Unit,
    featuredGames:List<SimpleGame>,
    playlist: List<Playlist>,
    onPlaylistClick: (Long) -> Unit,
    ) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .nestedScroll
                    (scrollBehavior.nestedScrollConnection)
        ) {
            HomeTopBar(
                onMenuClick = onMenuClick
                , onSearchClick = onSearchClick,
                scrollBehavior
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    horizontal = 12.dp,
                    vertical = 12.dp
                ),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                item {
                    FeaturedGamesSection(featuredGames=featuredGames)


                }
                items (items = playlist.take(9),
                    key = { playlist -> playlist.id }) { playlist ->

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    GameSection(
                        onClickSeeAll ={onPlaylistClick(playlist.id)},
                        playlist = playlist
                    )
                }
                item{
                    HomeFooter()
                }
            }

        }
    }

