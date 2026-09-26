package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.filter.GameFilter
import ir.companymeerkats.meerkatdex.model.network.repository.GameProvider
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject  constructor(
     val gameProvider: GameProvider
):ViewModel (){
    val getGames: StateFlow<UiState<List<Game>>> =
        gameProvider.getGames()
            .map<List<Game>, UiState<List<Game>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.Loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.Loading)
    private val _gameIdState =
        MutableStateFlow<UiState<Game>>(UiState.Loading)

    val gameIdState =
        _gameIdState.asStateFlow()
    fun getGameById(id:Long) {
        viewModelScope.launch {
            _gameIdState.value = UiState.Loading

            try {
                val game = gameProvider.getGameById(id)
                _gameIdState.value = UiState.Success(game)
            } catch (e: Exception) {
                e.printStackTrace()

                _gameIdState.value = UiState.Error(
                    e.stackTraceToString()
                )
            }
        }
    }
    private val _gameFilterState =
        MutableStateFlow<UiState<List<SimpleGame>>>(UiState.Loading)

    val gameFilterState =
        _gameFilterState.asStateFlow()

    fun gameGamesFilter(query: String) {
        if (query.isBlank()) return
        viewModelScope.launch {
            _gameFilterState.value = UiState.Loading

            try {
                gameProvider
                    .getGamesByFilter(GameFilter(query))
                    .collect { games ->

                        _gameFilterState.value =
                            if (games.isEmpty()) {
                                UiState.Success(emptyList())
                            } else {
                                UiState.Success(games)
                            }
                    }

            } catch (e: Exception) {
                _gameFilterState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}