package ir.companymeerkats.meerkatdex

import android.app.Application
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import dagger.hilt.android.HiltAndroidApp
import ir.companymeerkats.meerkatdex.model.GameRequirement
import ir.companymeerkats.meerkatdex.model.Genre
import ir.companymeerkats.meerkatdex.model.Platform
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.model.Rating
import ir.companymeerkats.meerkatdex.model.Requirement
import ir.companymeerkats.meerkatdex.model.SimpleGame
import timber.log.Timber

@HiltAndroidApp
class MeerkatDexApplication:Application() {
    val featuredGames:List<SimpleGame> = createDataForTestListSimpleGame()
    val playlist:List<Playlist> = createDataForTestPlaylist()
    val platformList:List<Platform> = createDataForTestListPlatform()
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
    fun createDataForTestListPlatform(): List<Platform>{
        return listOf(
            Platform(0,
                "android"
                , R.drawable.android
                ,"2.0.9"
                , "2024"
                , "100 mb"
                , GameRequirement(0
                , Requirement
                (0,"4","andorid 12","cpu 16","rx 10","100 mb"),
                    Requirement
                        (0,"4","andorid 12","cpu 16","rx 10","100 mb"))
                ),
            Platform(1,
                "iPhone"
                , R.drawable.iphone
                ,"2.0.9"
                , "2024"
                , "100 mb"
                , GameRequirement(0
                    , Requirement
                        (0,"4","iphone 16","cpu 16","rx 10","100 mb"),
                    Requirement
                        (0,"4","iphone 16","cpu 16","rx 10","100 mb"))
            )
        )
    }
    fun createDataForTestListSimpleGame():List<SimpleGame>{
        val platformList:List<Platform> = createDataForTestListPlatform()

        return listOf(
            SimpleGame(
                id = 1,
                name = "Brawl Stars",
                imageCover = R.drawable.brawl_stars,
                imageIcon = R.drawable.brawl_stars_icon,
                rating = listOf(Rating(0,"4.5","","4.5","")),
                genres = listOf(Genre(0,"Actoin"),
                    Genre(1,"Strategy"),
                    Genre(2,"Multiplayer")),
                platform= platformList
            ),

            SimpleGame(
                id = 2,
                name = "Minecraft",
                imageCover = R.drawable.minecraft,
                imageIcon = R.drawable.minecraft_icon,
                rating = listOf(Rating(0,"4.5","","4.5","")),
                genres = listOf(Genre(0,"Adventure"),
                    Genre(1,"Sandbox")),
                platform= platformList
            ),

            SimpleGame(
                id = 3,
                name = "Genshin Impact",
                imageCover = R.drawable.genshin_impact,
                imageIcon = R.drawable.genshin_impact_icon,
                rating = listOf(Rating(0,"4.5","","4.5","")),
                genres = listOf(Genre(0,"RPG"),
                    Genre(1,"Adventure")),
                platform= platformList
            )
        )
    }
    fun createDataForTestPlaylist():List<Playlist>{
        return listOf(
            Playlist(
                id = 0,
                name ="\uD83D\uDD25Popular games",
                description = "the most played and loved games by our community",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 1,
                name = "Recently Added",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 2,
                name = "Top Rated",
                description = "",
                number=100,
                games = featuredGames
        ),
            Playlist(
                id = 3,
                name = "Action Games",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 4,
                name = "Adventure Games",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 5,
                name = "RPG Games",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 6,
                name = "Racing Games",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 7,
                name = "Sports Games",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 8,
                name = "Coming Soon",
                description = "",
                number=100,
                games = featuredGames
            ),
            Playlist(
                id = 9,
                name = "test",
                description = "",
                number=100,
                games = featuredGames
            )
        )
    }
}