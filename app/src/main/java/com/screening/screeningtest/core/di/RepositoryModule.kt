package com.screening.screeningtest.core.di

import com.screening.screeningtest.core.data.GuestRepository
import com.screening.screeningtest.core.data.source.local.CacheMapper
import com.screening.screeningtest.core.data.source.local.GuestDao
import com.screening.screeningtest.core.data.source.remote.network.ApiService
import com.screening.screeningtest.core.data.source.remote.network.NetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: ApiService,
        guestDao: GuestDao,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): GuestRepository {
        return GuestRepository(apiService, guestDao, cacheMapper, networkMapper)
    }
}
