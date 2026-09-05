package ir.companymeerkats.meerkatdex.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ir.companymeerkats.meerkatdex.ui.theme.MeerkatDexTheme

import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel

import ir.companymeerkats.meerkatdex.ui.theme.MeerkatDexTheme
import ir.companymeerkats.meerkatdex.viewModel.DeveloperViewModel
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeerkatDexTheme {
                Timber.tag("@testGame").e("loading" )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetDataViewModelTest(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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
@Composable
fun SetDataViewModelTest(modifier: Modifier = Modifier){

    val viewModel: GameViewModel = hiltViewModel()

    val gameState by viewModel.gameState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getGameById(1L)
    }

    when (val state = gameState) {

        UiState.loading -> {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeerkatDexTheme {
        SetDataViewModelTest()
    }
}