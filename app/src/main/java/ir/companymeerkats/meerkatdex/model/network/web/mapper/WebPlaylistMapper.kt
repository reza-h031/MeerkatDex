package ir.companymeerkats.meerkatdex.model.network.web.mapper

import ir.companymeerkats.meerkatdex.mode.web.model.WebPlaylist
import ir.companymeerkats.meerkatdex.model.Playlist
import java.util.stream.Collectors

class WebPlaylistMapper(
    val webSimpleGameMapper: WebSimpleGameMapper
) {
    fun toPlaylist(webPlaylist: WebPlaylist): Playlist{
        return Playlist(webPlaylist.id,webPlaylist.name,webPlaylist.description,webPlaylist.number,
            webPlaylist.games.stream().map(webSimpleGameMapper::toSimpleGame).collect(Collectors.toList()))
    }
    fun toWebPlaylist(playlist: Playlist): WebPlaylist{
        return WebPlaylist(playlist.id,playlist.name,playlist.description,playlist.number,
            playlist.games.stream().map(webSimpleGameMapper::toWebSimpleGame).collect(Collectors.toList()))
    }
}