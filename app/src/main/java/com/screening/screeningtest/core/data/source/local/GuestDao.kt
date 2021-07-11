package com.screening.screeningtest.core.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GuestDao {
    @Query("SELECT * FROM guestEntities")
    suspend fun getGuest(): List<GuestCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuest(guestEntity: GuestCacheEntity): Long

}