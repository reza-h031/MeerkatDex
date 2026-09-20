package ir.companymeerkats.meerkatdex.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.companymeerkats.meerkatdex.model.network.repository.DeveloperProvider
import ir.companymeerkats.meerkatdex.model.network.repository.DeveloperRepository
import ir.companymeerkats.meerkatdex.model.network.repository.GameProvider
import ir.companymeerkats.meerkatdex.model.network.repository.GameRepository
import ir.companymeerkats.meerkatdex.model.network.repository.GenreProvider
import ir.companymeerkats.meerkatdex.model.network.repository.GenreRepository
import ir.companymeerkats.meerkatdex.model.network.repository.PlatformProvider
import ir.companymeerkats.meerkatdex.model.network.repository.PlatformRepository
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherProvider
import ir.companymeerkats.meerkatdex.model.network.repository.PublisherRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDeveloperProvider(
        repository: DeveloperRepository
    ): DeveloperProvider

    @Binds
    abstract fun bindGameProvider(
        repository: GameRepository
    ): GameProvider

    @Binds
    abstract fun bindGenreProvider(
        repository: GenreRepository
    ): GenreProvider

    @Binds
    abstract fun bindPlatformProvider(
        repository: PlatformRepository
    ): PlatformProvider

    @Binds
    abstract fun bindPublisherProvider(
        repository: PublisherRepository
    ): PublisherProvider
}