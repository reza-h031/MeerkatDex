package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.model.Publisher
import ir.companymeerkats.meerkatdex.model.network.repository.PlaylistProvider
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherProvider
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
class PlaylistViewModel @Inject  constructor(
    val playlistProvider: PlaylistProvider
) : ViewModel(){
    val getPlaylists: StateFlow<UiState<List<Playlist>>> =
        playlistProvider.getPlaylists()
            .map <List<Playlist>, UiState<List<Playlist>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.Loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                UiState.Loading)
    private val _playlistIdState=
        MutableStateFlow<UiState<Playlist>>(UiState.Loading)
    val playlistIdState=
        _playlistIdState.asStateFlow()
    fun playlistById(id: Long){
        viewModelScope.launch {
            _playlistIdState.value= UiState.Loading
            try {
               val playlist= playlistProvider.getPlaylistById(id)
                _playlistIdState.value= UiState.Success(playlist)
            }catch (e: Exception) {
                _playlistIdState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}