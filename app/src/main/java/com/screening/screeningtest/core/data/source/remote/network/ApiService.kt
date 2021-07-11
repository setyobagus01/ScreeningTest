package com.screening.screeningtest.core.data.source.remote.network

import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getGuests(): List<GuestNetworkEntity>
}