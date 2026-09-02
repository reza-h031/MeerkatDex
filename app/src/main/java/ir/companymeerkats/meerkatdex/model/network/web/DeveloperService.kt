package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebDeveloper
import retrofit2.http.*
import kotlinx.coroutines.flow.Flow

interface DeveloperService {
    @GET("developers")
    fun getDevelopers(): Flow<List<WebDeveloper>>

    @GET("developers/{id}")
    suspend fun getDeveloperById(@Path("id") id:Long):WebDeveloper
}