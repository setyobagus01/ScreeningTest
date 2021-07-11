package com.screening.screeningtest.core.data.source.remote.network

import com.google.gson.annotations.SerializedName

data class GuestNetworkEntity(
    @field:SerializedName("birthdate")
    val birthdate: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)