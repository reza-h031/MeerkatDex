package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlatform
import ir.companymeerkats.meerkatdex.model.Platform
import ir.companymeerkats.meerkatdex.model.SimplePlatform
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimplePlatform

class WebSimplePlatformMapper {
    fun toPlatform(webPlatform: WebSimplePlatform):SimplePlatform{
        return SimplePlatform(webPlatform.id,webPlatform.name,webPlatform.logo)
    }
    fun toWebPlatform(platform: SimplePlatform):WebSimplePlatform{
        return WebSimplePlatform(platform.id,platform.name,platform.logo)
    }
}