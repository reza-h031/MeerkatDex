package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.Platform
import ir.companymeerkats.meerkatdex.model.network.repository.PlatformProvider
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
class PlatformViewModel @Inject  constructor(
      val platformRepository: PlatformProvider
) : ViewModel(){
    val getPlatforms: StateFlow<UiState<List<Platform>>> =
        platformRepository.getPlatforms()
            .map<List<Platform>, UiState<List<Platform>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.loading)

    val _platformState =
        MutableStateFlow<UiState<Platform>>(UiState.loading)

    val platformState: StateFlow<UiState<Platform>> =
        _platformState
    fun getPlatformById(id:Long): StateFlow<UiState<Platform>> {
        viewModelScope.launch {
            _platformState.value = UiState.loading

            try {
                val platform = platformRepository.getPlatformById(id)
                _platformState.value = UiState.Success(platform)
            } catch (e: Exception) {
                _platformState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
        return platformState
    }
}