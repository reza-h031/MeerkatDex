package ir.companymeerkats.meerkatdex.di

import ir.companymeerkats.meerkatdex.model.network.web.DeveloperService
import ir.companymeerkats.meerkatdex.model.network.web.WebService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebDeveloperMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.companymeerkats.meerkatdex.model.network.repository.DeveloperRepository
import ir.companymeerkats.meerkatdex.model.network.repository.GameRepository
import ir.companymeerkats.meerkatdex.model.network.repository.GenreRepository
import ir.companymeerkats.meerkatdex.model.network.repository.PlatformRepository
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherRepository
import ir.companymeerkats.meerkatdex.model.network.web.GameService
import ir.companymeerkats.meerkatdex.model.network.web.GenresService
import ir.companymeerkats.meerkatdex.model.network.web.PlatformsService
import ir.companymeerkats.meerkatdex.model.network.web.PublisherService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameImageMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameRequirementMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGenreMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPlatformMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPublisherMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebRatingMapper
import ir.companymeerkats.meerkatdex.viewModel.DeveloperViewModel
import ir.companymeerkats.meerkatdex.viewModel.GameViewModel
import ir.companymeerkats.meerkatdex.viewModel.GenreViewModel
import ir.companymeerkats.meerkatdex.viewModel.PlatformViewModel
import ir.companymeerkats.meerkatdex.viewModel.PublisherViewModel
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
//    developer
    @Provides
    fun provideDeveloperService(webService: WebService):DeveloperService{
        return webService.getDeveloperService()
    }
    @Singleton
    @Provides
    fun provideDeveloperMapper():WebDeveloperMapper{
        return WebDeveloperMapper()
    }
    @Singleton
    @Provides
    fun provideDeveloperRepository(developerService: DeveloperService,webDeveloperMapper: WebDeveloperMapper):DeveloperRepository{
        return DeveloperRepository(developerService,webDeveloperMapper)
    }
    @Singleton
    @Provides
    fun developerViewModel(developerRepository: DeveloperRepository):DeveloperViewModel{
        return DeveloperViewModel(developerRepository)
    }
//    genres

    @Provides
    fun provideGenreService(webService: WebService):GenresService{
        return webService.getGenresService()
    }
    @Singleton
    @Provides
    fun provideGenreMapper():WebGenreMapper{
        return WebGenreMapper()
    }
    @Singleton
    @Provides
    fun provideGenresRepository(genresService: GenresService,webGenresMapper: WebGenreMapper): GenreRepository {
        return GenreRepository(genresService,webGenresMapper)
    }
    @Singleton
    @Provides
    fun genreViewModel(genreRepository: GenreRepository): GenreViewModel {
        return GenreViewModel(genreRepository)
    }
//    platform

    @Provides
    fun providePlatformService(webService: WebService): PlatformsService {
        return webService.getPlatformsService()
    }
    @Singleton
    @Provides
    fun providePlatformMapper(webRequirementMapper: WebGameRequirementMapper):WebPlatformMapper{
        return WebPlatformMapper(webRequirementMapper)
    }
    @Singleton
    @Provides
    fun providePlatformRepository(platformService: PlatformsService,webPlatformMapper: WebPlatformMapper): PlatformRepository {
        return PlatformRepository(platformService,webPlatformMapper)
    }
    @Singleton
    @Provides
    fun platformViewModel(platformRepository: PlatformRepository):PlatformViewModel{
        return PlatformViewModel(platformRepository)
    }
//    publisher

    @Provides
    fun providePublisherService(webService: WebService): PublisherService {
        return webService.getPublisherService()
    }
    @Singleton
    @Provides
    fun providePublisherMapper():WebPublisherMapper{
        return WebPublisherMapper()
    }
    @Singleton
    @Provides
    fun providePublisherRepository(publisherService: PublisherService,webPublisherMapper: WebPublisherMapper): PublisherRepository {
        return PublisherRepository(publisherService,webPublisherMapper)
    }
    @Singleton
    @Provides
    fun publisherViewModel(publisherRepository: PublisherRepository):PublisherViewModel{
        return PublisherViewModel(publisherRepository)
    }
//    game
    @Provides
    fun provideGameService(webService: WebService): GameService {
        return webService.getGameService()
    }
    @Singleton
    @Provides
    fun provideGameMapper(
        developerMapper: WebDeveloperMapper,
        publisherMapper: WebPublisherMapper,
        platformMapper: WebPlatformMapper,
        genreMapper: WebGenreMapper,
        imageMapper: WebGameImageMapper,
        ratingMapper: WebRatingMapper
    ): WebGameMapper {
        return WebGameMapper(developerMapper, publisherMapper, platformMapper, genreMapper, imageMapper, ratingMapper)
    }
    @Singleton
    @Provides
    fun provideGameRepository(gameService: GameService,webGameMapper: WebGameMapper): GameRepository {
        return GameRepository(gameService,webGameMapper)
    }
    @Singleton
    @Provides
    fun gameViewModel(gameRepository: GameRepository):GameViewModel{
        return GameViewModel(gameRepository)
    }

//    webService
    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return WebService(retrofit)
    }
}