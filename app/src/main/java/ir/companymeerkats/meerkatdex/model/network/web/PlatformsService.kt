package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlatform
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PlatformsService {
    @GET("platforms")
    fun getPlatforms():Flow<List<WebPlatform>>
    @GET("platforms/{id}")
    suspend fun getPlatformById(@Path("id") id:Long):WebPlatform
}