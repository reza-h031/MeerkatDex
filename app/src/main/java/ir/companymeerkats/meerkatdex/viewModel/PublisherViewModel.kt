package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Publisher
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherProvider
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
class PublisherViewModel @Inject  constructor(
 val publisherRepository: PublisherProvider
) : ViewModel(){
    val getPublishers: StateFlow<UiState<List<Publisher>>> =
        publisherRepository.getPublishers()
            .map<List<Publisher>, UiState<List<Publisher>>>{
                UiState.Success(it)
            }.onStart {
                emit(UiState.loading)
            }.catch {
                emit(UiState.Error(it.message?:"Unknown error"))
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.loading)
    val _publisherState =
        MutableStateFlow<UiState<Publisher>>(UiState.loading)

    val publisherState: StateFlow<UiState<Publisher>> =
        _publisherState
    fun getPublisherById(id:Long): StateFlow<UiState<Publisher>> {
        viewModelScope.launch {
            _publisherState.value = UiState.loading

            try {
                val publisher = publisherRepository.getPublisherById(id)
                _publisherState.value = UiState.Success(publisher)
            } catch (e: Exception) {
                _publisherState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
        return publisherState
    }
}