package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.model.Requirement
import ir.companymeerkats.meerkatdex.model.network.web.model.WebRequirement

class WebRequirementMapper {
    fun toRequirement(webRequirement: WebRequirement):Requirement{
        return Requirement(webRequirement.id,webRequirement.ram,webRequirement.systemVersion,webRequirement.cpu,webRequirement.gpu,webRequirement.storage)
    }
    fun toWebRequirement(requirement: Requirement):WebRequirement{
        return WebRequirement(requirement.id,requirement.ram,requirement.systemVersion,requirement.cpu,requirement.gpu,requirement.storage)
    }
}