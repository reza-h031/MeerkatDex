package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebGenre
import ir.companymeerkats.meerkatdex.model.Genre

class WebGenreMapper {
    fun toGenre(webGenre: WebGenre):Genre{
        return Genre(webGenre.id,webGenre.name)
    }
    fun toWebGenre(genre: Genre):WebGenre{
        return WebGenre(genre.id,genre.name)
    }
}