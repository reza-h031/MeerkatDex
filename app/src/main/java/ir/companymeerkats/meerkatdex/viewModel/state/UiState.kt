package ir.companymeerkats.meerkatdex.viewModel.state

sealed class UiState <out T> {
    data object loading:UiState<Nothing>()
    data class Success<T>(val data:T):UiState<T>()
    data class Error(val message:String):UiState<Nothing>()
}