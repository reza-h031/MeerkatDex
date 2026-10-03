package ir.companymeerkats.meerkatdex.model.network.repository

import ir.companymeerkats.meerkatdex.model.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistProvider {
    fun getPlaylists(): Flow<List<Playlist>>
    suspend fun getPlaylistById(id:Long): Playlist
}