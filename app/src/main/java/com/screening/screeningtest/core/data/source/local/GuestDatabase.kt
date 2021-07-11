package com.screening.screeningtest.core.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GuestCacheEntity::class], version = 1, exportSchema = false)
abstract class GuestDatabase : RoomDatabase() {
    abstract fun guestDao(): GuestDao

    companion object {
        val DATABASE_NAME: String = "Guest.db"
    }
}