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
import ir.companymeerkats.meerkatdex.model.network.repository.PlaylistRepository
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherRepository
import ir.companymeerkats.meerkatdex.model.network.web.GameService
import ir.companymeerkats.meerkatdex.model.network.web.GenresService
import ir.companymeerkats.meerkatdex.model.network.web.MediaUrlResolver
import ir.companymeerkats.meerkatdex.model.network.web.PlatformsService
import ir.companymeerkats.meerkatdex.model.network.web.PlaylistsService
import ir.companymeerkats.meerkatdex.model.network.web.PublisherService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameImageMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGameRequirementMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGenreMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPlatformMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPlaylistMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPublisherMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebRatingMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebSimpleGameMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebSimplePlatformMapper
import ir.companymeerkats.meerkatdex.model.network.web.mapper.request.RequestMapper
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimpleGame
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
    fun providePlatformSimple(): WebSimplePlatformMapper{
        return WebSimplePlatformMapper()
    }
    @Singleton
    @Provides
    fun providePlatformRepository(platformService: PlatformsService,webPlatformMapper: WebPlatformMapper): PlatformRepository {
        return PlatformRepository(platformService,webPlatformMapper)
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
    fun provideSimpleGameMapper(
        platformMapper: WebSimplePlatformMapper,
        genreMapper: WebGenreMapper,
        ratingMapper: WebRatingMapper,
        mediaUrlResolver: MediaUrlResolver
    ): WebSimpleGameMapper{
        return WebSimpleGameMapper(platformMapper, genreMapper, ratingMapper,mediaUrlResolver)
    }
    @Singleton
    @Provides
    fun provideGameRepository(gameService: GameService,webGameMapper: WebGameMapper,
                              webSimpleGameMapper: WebSimpleGameMapper,
                              requestMapper: RequestMapper): GameRepository {
        return GameRepository(gameService,webGameMapper,webSimpleGameMapper,requestMapper)
    }
//    filters

    @Singleton
    @Provides
    fun provideFilterMapper(): RequestMapper{
    return RequestMapper()
    }
//    playlist
    @Provides
    fun providePlaylistService(webService: WebService): PlaylistsService {
        return webService.getPlaylistsService()
    }
    @Singleton
    @Provides
    fun providePlaylistMapper(webSimpleGameMapper: WebSimpleGameMapper): WebPlaylistMapper{
        return WebPlaylistMapper(webSimpleGameMapper)
    }
    @Singleton
    @Provides
    fun providePlaylistRepository(
         playlistsService: PlaylistsService,
         webPlaylistMapper: WebPlaylistMapper
    ): PlaylistRepository{
        return PlaylistRepository(playlistsService,webPlaylistMapper)
    }

//    webService

    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return WebService(retrofit)
    }
}