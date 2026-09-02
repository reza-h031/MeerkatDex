package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGame
import ir.companymeerkats.meerkatdex.model.Game
import java.util.stream.Collectors

class WebGameMapper(
    val developerMapper: WebDeveloperMapper,
    val publisherMapper: WebPublisherMapper,
    val platformMapper: WebPlatformMapper,
    val genreMapper: WebGenreMapper,
    val imageMapper: WebGameImageMapper,
    val ratingMapper: WebRatingMapper
) {
    fun toGame(webGame: WebGame):Game{
        return Game(webGame.id,webGame.title,webGame.description,
            webGame.releaseDate,developerMapper.toDeveloper(webGame.developer),
            publisherMapper.toPublisher(webGame.publisher),
            webGame.website,webGame.status,
            webGame.platform.stream().map(platformMapper::toPlatform).collect(Collectors.toList()),
            webGame.genre.stream().map(genreMapper::toGenre).collect(Collectors.toList()),
            webGame.images.stream().map(imageMapper::toImage).collect(Collectors.toList()),
            webGame.ratings.stream().map(ratingMapper::toRating).collect(Collectors.toList()))
    }
    fun toWebGame(game: Game):WebGame{
        return WebGame(game.id,game.title,game.description,
            game.releaseDate,developerMapper.toWebDeveloper(game.developer)
            ,publisherMapper.toWebPublisher(game.publisher),
            game.website,game.status,
            game.platform.stream().map(platformMapper::toWebPlatform).collect(Collectors.toList()),
            game.genre.stream().map(genreMapper::toWebGenre).collect(Collectors.toList()),
            game.images.stream().map(imageMapper::toWebImage).collect(Collectors.toList()),
            game.ratings.stream().map(ratingMapper::toWebRating).collect(Collectors.toList()))
    }
}