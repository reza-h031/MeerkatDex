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
import ir.companymeerkats.meerkatdex.model.SimplePlatform
import timber.log.Timber


@HiltAndroidApp
class MeerkatDexApplication:Application() {
    val BuildConfig:Boolean=false
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig) {
            Timber.plant(Timber.DebugTree())
        }
    }

}