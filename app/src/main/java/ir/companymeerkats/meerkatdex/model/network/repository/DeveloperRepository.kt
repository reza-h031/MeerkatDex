package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebDeveloper
import ir.companymeerkats.meerkatdex.model.Developer
import ir.companymeerkats.meerkatdex.model.network.web.DeveloperService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebDeveloperMapper
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DeveloperRepository(@Inject
    val developerService: DeveloperService,
    val webDeveloperMapper: WebDeveloperMapper
):DeveloperProvider {
    override fun getDevelopers(): Flow<List<Developer>> {
        return developerService.getDevelopers().map{webDeveloper: List<WebDeveloper> ->
            webDeveloper.map(webDeveloperMapper::toDeveloper)}

    }

    override suspend fun getDeveloperById(id:Long): Developer {
        return webDeveloperMapper.toDeveloper(developerService.getDeveloperById(id))
    }
}