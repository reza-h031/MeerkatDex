package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGameImage
import ir.companymeerkats.meerkatdex.model.GameImage
import ir.companymeerkats.meerkatdex.model.network.web.MediaUrlResolver
import javax.inject.Inject

class WebGameImageMapper @Inject constructor(
    private val mediaUrlResolver: MediaUrlResolver
) {

    fun toImage(webGameImage: WebGameImage): GameImage {
        return GameImage(
            id = webGameImage.id,
            path = mediaUrlResolver.resolve(webGameImage.path).orEmpty(),
            type = webGameImage.type
        )
    }

    fun toWebImage(gameImage: GameImage): WebGameImage {
        return WebGameImage(
            id = gameImage.id,
            path = gameImage.path,
            type = gameImage.type
        )
    }
}