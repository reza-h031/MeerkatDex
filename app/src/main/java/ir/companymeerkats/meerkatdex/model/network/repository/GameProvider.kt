package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.filter.GameFilter
import kotlinx.coroutines.flow.Flow

interface GameProvider {
    fun getGames():Flow<List<Game>>
    suspend fun getGameById(id:Long):Game
    fun getGamesByFilter(gameFilter: GameFilter): Flow<List<SimpleGame>>
}