package ir.companymeerkats.meerkatdex.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.companymeerkats.meerkatdex.view.game.GameDetailScreen
import ir.companymeerkats.meerkatdex.view.home.HomeScreen
import ir.companymeerkats.meerkatdex.view.more.MoreScreen
import ir.companymeerkats.meerkatdex.view.search.SearchScreen
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.view.home.drawer.HomeDrawer
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.view.playlist.PlaylistScreen
import kotlinx.coroutines.launch
import androidx.navigation.NavType
import androidx.navigation.navArgument

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(
    featuredGames:List<SimpleGame>,
    playlist: List<Playlist>
) {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val showBottomBar : Boolean = currentRoute in setOf(
        Screen.Home.route,
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomeDrawer()
        }
    ) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    navController = navController
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Screen.Home.route) {

                HomeScreen(

                    featuredGames=featuredGames,
                    playlist = playlist,
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    onGameClick = { gameId ->
                        navController.navigate(
                            Screen.GameDetail.createRoute(gameId)
                        )
                    },

                    onSearchClick = {
                        navController.navigate(
                            Screen.Search.route
                        )
                    },
                    onPlaylistClick = { playlistId ->
                        navController.navigate(
                            Screen.Playlist.createRoute(playlistId)
                        )
                    }

                )
            }

            composable(Screen.Search.route) {
                SearchScreen()
            }

            composable(
                route = Screen.GameDetail.route
            ) {
                GameDetailScreen(
//                    onBackClick = {
//                        navController.popBackStack()
//                    }
                )
            }
            composable(
                route = Screen.Playlist.route,
                arguments = listOf(
                    navArgument("playlistId") {
                        type = NavType.LongType
                    }
                )
            ) { backStackEntry ->

                val playlistId =
                    backStackEntry.arguments?.getLong("playlistId")

                val selectedPlaylist =
                    playlist.find { it.id == playlistId }

                selectedPlaylist?.let { selectedPlaylist ->

                    PlaylistScreen(
                        playlist = selectedPlaylist,

                        onBackClick = {
                            navController.popBackStack()
                        },

                        onGameClick = { gameId ->
                            navController.navigate(
                                Screen.GameDetail.createRoute(gameId)
                            )
                        }
                    )
                }
            }

            composable(Screen.More.route) {
                MoreScreen()
            }
        }
    }
}
}
@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavigationBar {

        NavigationBarItem(
            selected = currentRoute == Screen.Home.route,
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home")
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = currentRoute == Screen.Search.route,
            onClick = {
                navController.navigate(Screen.Search.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search")
                   },
            label = {
                Text("Search")
            }
        )

        NavigationBarItem(
            selected = currentRoute == Screen.More.route,
            onClick = {
                navController.navigate(Screen.More.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "Search")
                   },
            label = {
                Text("More")
            }
        )
    }
}