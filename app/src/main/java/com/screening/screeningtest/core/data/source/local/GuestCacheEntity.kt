package com.screening.screeningtest.core.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guestEntities")
data class GuestCacheEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "birthDate")
    var birthDate: String,

    @ColumnInfo(name = "image")
    var image: String,
)