package ir.companymeerkats.meerkatdex.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.companymeerkats.meerkatdex.MeerkatDexApplication
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.ui.theme.MeerkatDexTheme
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.view.navigation.AppNavigation
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import timber.log.Timber

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application: MeerkatDexApplication = application as MeerkatDexApplication
        setContent {
            MeerkatDexTheme {
                MeerkatDexApp(application.featuredGames,application.playlist)
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//
//}
@ExperimentalMaterial3Api
@Composable
fun MeerkatDexApp(featuredGames:List<SimpleGame>,playlist:List<Playlist>) {
    AppNavigation(featuredGames,playlist)
    Timber.tag("@testGetDataApplication").e(featuredGames.toString())
}
@Composable
fun SetDataViewModelTest(modifier: Modifier = Modifier){

    val viewModel: GameViewModel = hiltViewModel()

    val gameState by viewModel.gameIdState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getGameById(1L)
    }

    when (val state = gameState) {

        UiState.Loading -> {
            Timber.tag("@testGame").e("loading" )
            CircularProgressIndicator()
        }

        is UiState.Success -> {
            val game = state.data
            Timber.tag("@testGame").e(".." + game.toString())

            Text(
                text = game.title,
                modifier = modifier
            )
        }

        is UiState.Error -> {
            Timber.tag("@testGame").e("" + state.message)
            Text(
                text = state.message
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeerkatDexTheme {
    }
}