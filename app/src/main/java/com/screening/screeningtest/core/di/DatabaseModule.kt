package com.screening.screeningtest.core.di

import android.content.Context
import androidx.room.Room
import com.screening.screeningtest.core.data.source.local.GuestDao
import com.screening.screeningtest.core.data.source.local.GuestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): GuestDatabase {
        return Room.databaseBuilder(
            context,
            GuestDatabase::class.java,
            GuestDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideGuestDao(guestDatabase: GuestDatabase): GuestDao {
        return guestDatabase.guestDao()
    }
}