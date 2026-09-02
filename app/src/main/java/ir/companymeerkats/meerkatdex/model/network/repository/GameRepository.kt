package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebGame
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.network.web.GameService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameRepository (@Inject
    val gameService: GameService,
    val webGameMapper: WebGameMapper
):GameProvider{
    override fun getGames(): Flow<List<Game>> {
        return gameService.getGames().map { webGame: List<WebGame> -> webGame.map (webGameMapper::toGame)}
    }

    override suspend fun getGameById(id: Long): Game {
        return webGameMapper.toGame(gameService.getGameById(id))
    }
}