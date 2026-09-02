package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebPublisher
import ir.companymeerkats.meerkatdex.model.Publisher

class WebPublisherMapper {
    fun toPublisher(webPublisher: WebPublisher):Publisher{
        return Publisher(webPublisher.id,webPublisher.name,webPublisher.logo,webPublisher.website)
    }
    fun toWebPublisher(publisher: Publisher):WebPublisher{
        return WebPublisher(publisher.id,publisher.name,publisher.logo,publisher.website)
    }
}