package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebRating
import ir.companymeerkats.meerkatdex.model.Rating

class WebRatingMapper {
    fun toRating(webRating: WebRating): Rating {
        return Rating(webRating.id,webRating.source,webRating.logoSource,webRating.rating,webRating.ratingCount)
    }
    fun toWebRating(rating: Rating):WebRating{
        return WebRating(rating.id,rating.source,rating.logoSource,rating.rating,rating.ratingCount)
    }
}