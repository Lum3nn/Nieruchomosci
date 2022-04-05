package com.lumen.nieruchomosci.commons.injection

import com.lumen.nieruchomosci.commons.repository.FakeUserRepository
import com.lumen.nieruchomosci.commons.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository() : UserRepository {
        return FakeUserRepository()
    }

}