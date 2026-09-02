package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Platform
import kotlinx.coroutines.flow.Flow

interface PlatformProvider {
    fun getPlatforms():Flow<List<Platform>>
    suspend fun getPlatformById(id:Long):Platform
}