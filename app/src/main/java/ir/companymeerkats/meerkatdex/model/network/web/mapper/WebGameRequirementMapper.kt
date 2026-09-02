package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGameRequirement
import ir.companymeerkats.meerkatdex.model.GameRequirement

class WebGameRequirementMapper(
    val webRequirementMapper: WebRequirementMapper
) {
    fun toGameRequirement(webGameRequirement: WebGameRequirement):GameRequirement{
        return GameRequirement(webGameRequirement.id,webRequirementMapper.toRequirement(webGameRequirement.minimumRequirements),webRequirementMapper.toRequirement(webGameRequirement.recommendedRequirements))
    }
    fun toWebGameRequirement(gameRequirement: GameRequirement):WebGameRequirement{
        return WebGameRequirement(gameRequirement.id,webRequirementMapper.toWebRequirement(gameRequirement.minimumRequirements),webRequirementMapper.toWebRequirement(gameRequirement.recommendedRequirements))
    }
}