package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebGame
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface GameService {

    @GET("games")
    suspend fun getGames(): List<WebGame>

    @GET("games/{id}")
    suspend fun getGameById(
        @Path("id") id: Long
    ): WebGame
}