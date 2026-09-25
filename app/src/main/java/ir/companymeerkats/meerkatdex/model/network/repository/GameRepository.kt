package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebGame
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.filter.GameFilter
import ir.companymeerkats.meerkatdex.model.network.web.GameService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameRequirementMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebSimpleGameMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.request.RequestMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.collections.map

class GameRepository @Inject constructor(
    private val gameService: GameService,
    private val webGameMapper: WebGameMapper,
    private val webSimpleGameMapper: WebSimpleGameMapper,
    private val requestMapper: RequestMapper
):GameProvider{
    override fun getGames(): Flow<List<Game>> {
        return flow {
            val games = gameService.getGames()

            emit(
                games.map(webGameMapper::toGame)
            )
        }
    }

    override suspend fun getGameById(id: Long): Game {
        return webGameMapper.toGame(gameService.getGameById(id))
    }

    override fun getGamesByFilter(gameFilter: GameFilter): Flow<List<SimpleGame>> {
        return flow {
            val games = gameService.getGamesByFilter(
                requestMapper.toRequest(gameFilter)
            )
            emit(
                games.map(webSimpleGameMapper::toSimpleGame)
            )
        }
    }
}