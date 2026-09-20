package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlatform
import ir.companymeerkats.meerkatdex.model.Platform

class WebPlatformMapper (
    val webRequirementMapper: WebGameRequirementMapper
){
    fun toPlatform(webPlatform: WebPlatform):Platform{
        return Platform(webPlatform.id,webPlatform.name,0,webPlatform.version,webPlatform.releaseDate,webPlatform.downloadSize,webRequirementMapper.toGameRequirement(webPlatform.requirement))
    }
    fun toWebPlatform(platform: Platform):WebPlatform{
        return WebPlatform(platform.id,platform.name,platform.logo.toString(),platform.version,platform.releaseDate,platform.downloadSize,webRequirementMapper.toWebGameRequirement(platform.gameRequirement))
    }
}