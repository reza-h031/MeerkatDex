package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebGenre
import ir.companymeerkats.meerkatdex.model.Genre
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface GenresService {
    @GET("genres")
    fun getGenres():Flow<List<WebGenre>>
    @GET("genres{id}")
    suspend fun getGenreById(@Path("id") id:Long):WebGenre
}