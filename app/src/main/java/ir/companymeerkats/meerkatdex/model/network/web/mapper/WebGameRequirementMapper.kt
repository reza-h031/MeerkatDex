package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGameRequirement
import ir.companymeerkats.meerkatdex.model.GameRequirement
import javax.inject.Inject

class WebGameRequirementMapper @Inject constructor(
    private val webRequirementMapper: WebRequirementMapper
) {

    fun toGameRequirement(
        webGameRequirement: WebGameRequirement?
    ): GameRequirement? {
        return webGameRequirement?.let {
            GameRequirement(
                id = it.id,
                minimumRequirements = webRequirementMapper.toRequirement(it.minimumRequirements),
                recommendedRequirements = webRequirementMapper.toRequirement(it.recommendedRequirements)
            )
        }
    }

    fun toWebGameRequirement(
        gameRequirement: GameRequirement?
    ): WebGameRequirement? {
        return gameRequirement?.let {
            WebGameRequirement(
                id = it.id,
                minimumRequirements = webRequirementMapper.toWebRequirement(it.minimumRequirements),
                recommendedRequirements = webRequirementMapper.toWebRequirement(it.recommendedRequirements)
            )
        }
    }
}