package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.network.web.MediaUrlResolver
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimpleGame
import java.util.stream.Collectors

class WebSimpleGameMapper(
    val platformMapper: WebSimplePlatformMapper,
    val genreMapper: WebGenreMapper,
    val ratingMapper: WebRatingMapper,
    private val mediaUrlResolver: MediaUrlResolver
) {
    fun toSimpleGame(webSimpleGame: WebSimpleGame): SimpleGame{
     return SimpleGame(webSimpleGame.id,webSimpleGame.name
         , mediaUrlResolver.resolve(webSimpleGame.imageCover).orEmpty()
         , mediaUrlResolver.resolve(webSimpleGame.imageIcon).orEmpty()
         , webSimpleGame.rating.stream().map (ratingMapper::toRating).collect(Collectors.toList())
         ,webSimpleGame.genres.stream().map (genreMapper::toGenre).collect(Collectors.toList())
         ,webSimpleGame.platform.stream().map  (platformMapper::toPlatform).collect(Collectors.toList())
     )
    }
    fun toWebSimpleGame(simpleGame: SimpleGame): WebSimpleGame{
        return WebSimpleGame(simpleGame.id,simpleGame.name
        ,simpleGame.imageCover,simpleGame.imageIcon
        ,simpleGame.rating.stream().map(ratingMapper::toWebRating).collect(Collectors.toList())
        ,simpleGame.genres.stream().map(genreMapper::toWebGenre).collect(Collectors.toList())
        ,simpleGame.platform.stream().map(platformMapper::toWebPlatform).collect(Collectors.toList()))
    }
}