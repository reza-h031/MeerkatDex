package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.Game
import kotlinx.coroutines.flow.Flow

interface GameProvider {
    fun getGames():Flow<List<Game>>
    suspend fun getGameById(id:Long):Game
}