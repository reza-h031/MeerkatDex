package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Publisher
import kotlinx.coroutines.flow.Flow

interface PublisherProvider {
    fun getPublishers():Flow<List<Publisher>>
    suspend fun getPublisherById(id:Long):Publisher
}