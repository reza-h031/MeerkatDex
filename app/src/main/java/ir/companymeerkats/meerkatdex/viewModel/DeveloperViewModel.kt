package ir.companymeerkats.meerkatdex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.network.repository.DeveloperProvider
import ir.companymeerkats.meerkatdex.model.network.repository.DeveloperRepository
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
class DeveloperViewModel  @Inject  constructor(
    val developerRepository: DeveloperProvider
) :ViewModel(){
     val getDevelopers:StateFlow<UiState<List<Developer>>> =
         developerRepository.getDevelopers()
             .map<List<Developer>,UiState<List<Developer>>>{
                 UiState.Success(it)
             }.onStart {
                 emit(UiState.loading)
             }.catch {
                 emit(UiState.Error(it.message?:"Unknown error"))
             }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),UiState.loading)
    val _developerState =
        MutableStateFlow<UiState<Developer>>(UiState.loading)

    val developerState: StateFlow<UiState<Developer>> =
        _developerState
    fun getDeveloperById(id:Long):StateFlow<UiState<Developer>>{
        viewModelScope.launch {
            _developerState.value = UiState.loading

            try {
                val developer = developerRepository.getDeveloperById(id)
                _developerState.value = UiState.Success(developer)
            } catch (e: Exception) {
                _developerState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
        return developerState
    }
}