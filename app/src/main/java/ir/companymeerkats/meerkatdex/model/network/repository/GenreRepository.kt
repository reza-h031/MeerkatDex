package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.mode.web.model.WebGenre
import ir.companymeerkats.meerkatdex.model.Genre
import ir.companymeerkats.meerkatdex.model.network.web.GenresService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebGenreMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GenreRepository @Inject constructor(
    val genresService: GenresService,
    val webGenreMapper: WebGenreMapper
):GenreProvider {
    override fun getGenres(): Flow<List<Genre>> {
        return genresService.getGenres().map { webGenre: List<WebGenre> -> webGenre.map(webGenreMapper::toGenre) }
    }

    override suspend fun getGenresById(id: Long): Genre {
        return webGenreMapper.toGenre(genresService.getGenreById(id))
    }
}