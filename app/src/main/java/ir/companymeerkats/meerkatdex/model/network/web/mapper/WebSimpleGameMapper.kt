package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.network.web.model.WebSimpleGame
import java.util.stream.Collectors

class WebSimpleGameMapper(
    val platformMapper: WebPlatformMapper,
    val genreMapper: WebGenreMapper,
    val ratingMapper: WebRatingMapper
) {
    fun toSimpleGame(webSimpleGame: WebSimpleGame): SimpleGame{
     return SimpleGame(webSimpleGame.id,webSimpleGame.name
         , webSimpleGame.imageCover,webSimpleGame.imageIcon
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