package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.network.repository.GameProvider
import ir.companymeerkats.meerkatdex.viewModel.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel(
    @Inject val gameRepository: GameProvider
):ViewModel (){
    val getGames: StateFlow<UiState<List<Game>>> =
        gameRepository.getGames()
            .map<List<Game>, UiState<List<Game>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.loading)
    val _gameState =
        MutableStateFlow<UiState<Game>>(UiState.loading)

    val gameState: StateFlow<UiState<Game>> =
        _gameState
    fun getGameById(id:Long): StateFlow<UiState<Game>> {
        viewModelScope.launch {
            _gameState.value = UiState.loading

            try {
                val game = gameRepository.getGameById(id)
                _gameState.value = UiState.Success(game)
            } catch (e: Exception) {
                _gameState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
        return gameState
    }
}