package com.screening.screeningtest.core.data

import com.screening.screeningtest.core.data.source.local.CacheMapper
import com.screening.screeningtest.core.data.source.local.GuestDao
import com.screening.screeningtest.core.data.source.remote.network.ApiService
import com.screening.screeningtest.core.data.source.remote.network.NetworkMapper
import com.screening.screeningtest.core.data.utils.DataState
import com.screening.screeningtest.core.domain.model.Guest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GuestRepository constructor(
    private val apiService: ApiService,
    private val guestDao: GuestDao,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getGuests(): Flow<DataState<List<Guest>>> = flow {
        emit(DataState.Loading)
        try {
            val networkGuest = apiService.getGuests()

            val guests = networkMapper.mapFromEntityList(networkGuest)
            for (guest in guests) {
                guestDao.insertGuest(cacheMapper.mapToEntity(guest))
            }
            val cachedGuests = guestDao.getGuest()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedGuests)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}