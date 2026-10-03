package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Game
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.model.SimpleGame
import ir.companymeerkats.meerkatdex.model.filter.GameFilter
import ir.companymeerkats.meerkatdex.model.network.web.PlaylistsService
import ir.companymeerkats.meerkatdex.model.network.web.mapper.WebPlaylistMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistRepository@Inject constructor(
    private val playlistsService: PlaylistsService,
    private val webPlaylistMapper: WebPlaylistMapper
): PlaylistProvider{
    override fun getPlaylists(): Flow<List<Playlist>> {
        return flow{
            val playlists=playlistsService.getPlaylists()
            emit(
                playlists.map(webPlaylistMapper::toPlaylist)
            )
        }    }

    override suspend fun getPlaylistById(id: Long): Playlist {
        return webPlaylistMapper.toPlaylist(playlistsService.getPlaylistById(id))
    }


}