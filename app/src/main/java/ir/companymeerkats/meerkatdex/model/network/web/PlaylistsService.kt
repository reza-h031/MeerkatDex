package ir.companymeerkats.meerkatdex.model.network.web

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlaylist
import ir.companymeerkats.meerkatdex.model.Playlist
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaylistsService {
    @GET("playlists")
    suspend fun getPlaylists(): List<WebPlaylist>
    @GET("playlists/{id}")
    suspend fun getPlaylistById(@Path("id") id:Long): WebPlaylist
}