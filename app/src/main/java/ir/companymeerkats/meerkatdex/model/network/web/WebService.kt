package ir.companymeerkats.meerkatdex.model.network.web

import retrofit2.Retrofit

class WebService (
    val retrofit: Retrofit){
    private val developerService:DeveloperService=retrofit.create(DeveloperService::class.java)
    private val gameService:GameService=retrofit.create(GameService::class.java)
    private val genresService:GenresService=retrofit.create(GenresService::class.java)
    private val platformsService:PlatformsService=retrofit.create(PlatformsService::class.java)
    private val playlistsService:PlaylistsService=retrofit.create(PlaylistsService::class.java)
    private val publisherService:PublisherService=retrofit.create(PublisherService::class.java)
    fun getDeveloperService():DeveloperService{
        return developerService
    }
    fun getGameService():GameService{
        return gameService
    }
    fun getGenresService():GenresService{
        return genresService
    }
    fun getPlatformsService():PlatformsService{
        return platformsService
    }
    fun getPlaylistsService():PlaylistsService{
        return playlistsService
    }
    fun getPublisherService():PublisherService{
        return publisherService
    }
}