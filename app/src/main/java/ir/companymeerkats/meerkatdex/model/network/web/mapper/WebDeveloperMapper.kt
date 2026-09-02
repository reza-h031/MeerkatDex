package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebDeveloper
import ir.companymeerkats.meerkatdex.model.Developer

class WebDeveloperMapper {
    fun toDeveloper(webDeveloper: WebDeveloper):Developer{
        return Developer(webDeveloper.id,webDeveloper.name,webDeveloper.logo,webDeveloper.website)
    }
    fun toWebDeveloper(developer: Developer):WebDeveloper{
        return WebDeveloper(developer.id,developer.name,developer.logo,developer.website)
    }
}