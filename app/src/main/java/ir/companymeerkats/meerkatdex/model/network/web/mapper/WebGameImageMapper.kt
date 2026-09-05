package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGameImage
import ir.companymeerkats.meerkatdex.model.GameImage
import javax.inject.Inject

class WebGameImageMapper @Inject constructor() {
    fun toImage(webGameImage: WebGameImage):GameImage{
        return GameImage(webGameImage.id,webGameImage.path,webGameImage.type)
    }
    fun toWebImage(gameImage: GameImage):WebGameImage{
        return WebGameImage(gameImage.id,gameImage.path,gameImage.type)
    }

}