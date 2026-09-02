package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Genre
import kotlinx.coroutines.flow.Flow

interface GenreProvider {
    fun getGenres():Flow<List<Genre>>
    suspend fun getGenresById(id:Long):Genre
}