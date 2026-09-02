package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Developer
import kotlinx.coroutines.flow.Flow

interface DeveloperProvider {
    fun getDevelopers():Flow<List<Developer>>
    suspend fun getDeveloperById(id:Long):Developer
}