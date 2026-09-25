package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebGame
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimpleGame
import ir.companymeerkats.meerkatdex.model.network.web.model.request.GameRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface GameService {

    @GET("games")
    suspend fun getGames(): List<WebGame>

    @GET("games/{id}")
    suspend fun getGameById(
        @Path("id") id: Long
    ): WebGame
    @POST
    @Headers("Accept: application/json")
    suspend fun getGamesByFilter(@Body gameRequest: GameRequest): List<WebSimpleGame>

}