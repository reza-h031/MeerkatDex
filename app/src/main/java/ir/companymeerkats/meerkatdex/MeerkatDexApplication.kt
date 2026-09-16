package ir.companymeerkats.meerkatdex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ir.companymeerkats.meerkatdex.model.Playlist
import ir.companymeerkats.meerkatdex.model.SimpleGame
import timber.log.Timber

@HiltAndroidApp
class MeerkatDexApplication:Application() {
    val featuredGames:List<SimpleGame> = createDataForTestListSimpleGame()
    val playlist:List<Playlist> = createDataForTestPlaylist()
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
    fun createDataForTestListSimpleGame():List<SimpleGame>{

        return listOf(
            SimpleGame(
                id = 1,
                name = "Brawl Stars",
                imageCover = R.drawable.brawl_stars,
                imageIcon = R.drawable.brawl_stars_icon,
                rating = 4.5,
                genres = listOf("Action", "Strategy", "Multiplayer")
            ),

            SimpleGame(
                id = 2,
                name = "Minecraft",
                imageCover = R.drawable.minecraft,
                imageIcon = R.drawable.minecraft_icon,
                rating = 4.6,
                genres = listOf("Adventure", "Sandbox")
            ),

            SimpleGame(
                id = 3,
                name = "Genshin Impact",
                imageCover = R.drawable.genshin_impact,
                imageIcon = R.drawable.genshin_impact_icon,
                rating = 4.4,
                genres = listOf("RPG", "Adventure")
            )
        )
    }
    fun createDataForTestPlaylist():List<Playlist>{
        return listOf(
            Playlist(
                id = 0,
                name ="Popular games",
                games = featuredGames
            ),
            Playlist(
                id = 1,
                name = "Recently Added",
                games = featuredGames
            ),
            Playlist(
                id = 1,
                name = "test1",
                games = featuredGames
        ),
            Playlist(
                id = 1,
                name = "test2",
                games = featuredGames
            )
        )
    }
}