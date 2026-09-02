package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebPublisher
import ir.companymeerkats.meerkatdex.model.Publisher
import ir.companymeerkats.meerkatdex.model.network.web.PublisherService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPublisherMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PublisherRepository (@Inject
    val publisherService: PublisherService,
    val webPublisherMapper: WebPublisherMapper
):PublisherProvider{
    override fun getPublishers(): Flow<List<Publisher>> {
        return publisherService.getPublishers().map{webPublisher: List<WebPublisher> -> webPublisher.map(webPublisherMapper::toPublisher) }
    }

    override suspend fun getPublisherById(id: Long): Publisher {
        return webPublisherMapper.toPublisher(publisherService.getPublisherById(id))
    }
}