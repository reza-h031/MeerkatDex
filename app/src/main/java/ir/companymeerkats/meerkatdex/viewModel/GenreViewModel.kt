package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Genre
import ir.companymeerkats.meerkatdex.model.network.repository.GenreProvider
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
class GenreViewModel @Inject  constructor(
     val genreRepository: GenreProvider
) : ViewModel(){
    val getGenre: StateFlow<UiState<List<Genre>>> =
        genreRepository.getGenres()
            .map<List<Genre>, UiState<List<Genre>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.loading)
    val _genreState =
        MutableStateFlow<UiState<Genre>>(UiState.loading)

    val genreState: StateFlow<UiState<Genre>> =
        _genreState
    fun getGenreById(id:Long): StateFlow<UiState<Genre>> {
        viewModelScope.launch {
            _genreState.value = UiState.loading

            try {
                val genre = genreRepository.getGenresById(id)
                _genreState.value = UiState.Success(genre)
            } catch (e: Exception) {
                _genreState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
        return genreState
    }
}