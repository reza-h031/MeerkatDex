package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlatform
import ir.companymeerkats.meerkatdex.model.Platform
import ir.companymeerkats.meerkatdex.model.network.web.PlatformsService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPlatformMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlatformRepository @Inject constructor(
    val platformsService: PlatformsService,
    val webPlatformMapper: WebPlatformMapper
) : PlatformProvider{
    override fun getPlatforms(): Flow<List<Platform>> {
        return platformsService.getPlatforms().map { webPlatform: List<WebPlatform> -> webPlatform.map (webPlatformMapper::toPlatform) }
    }

    override suspend fun getPlatformById(id: Long): Platform {
        return webPlatformMapper.toPlatform(platformsService.getPlatformById(id))
    }
}