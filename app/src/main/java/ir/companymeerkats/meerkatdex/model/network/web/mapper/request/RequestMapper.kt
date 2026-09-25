package ir.companymeerkats.meerkatdex.model.network.web.mapper.request

import ir.companymeerkats.meerkatdex.model.filter.GameFilter
import ir.companymeerkats.meerkatdex.model.network.web.model.request.GameRequest
import javax.inject.Inject

class RequestMapper @Inject constructor(
){
    fun toFilter(gameRequest: GameRequest): GameFilter{
        return GameFilter(gameRequest.name)
    }
    fun toRequest(gameFilter: GameFilter): GameRequest{
        return GameRequest(gameFilter.name)
    }
}