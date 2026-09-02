package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebPublisher
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PublisherService {
    @GET("publishers")
    fun getPublishers():Flow<List<WebPublisher>>
    @GET("publishers/{id}")
    suspend fun getPublisherById(@Path("id") id:Long):WebPublisher
}