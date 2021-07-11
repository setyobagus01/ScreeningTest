package com.screening.screeningtest.core.data.source.remote.network

import com.screening.screeningtest.core.data.utils.EntityMapper
import com.screening.screeningtest.core.domain.model.Guest
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<GuestNetworkEntity, Guest> {
    override fun mapFromEntity(entity: GuestNetworkEntity): Guest {
        return Guest(
            id = entity.id,
            name = entity.name,
            birthDate = entity.birthdate,
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Sundar_Pichai_WEF_2020.png/220px-Sundar_Pichai_WEF_2020.png"
        )
    }

    override fun mapToEntity(domainModel: Guest): GuestNetworkEntity {
        return GuestNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            birthdate = domainModel.birthDate,
        )
    }

    fun mapFromEntityList(entities: List<GuestNetworkEntity>): List<Guest> {
        return entities.map { mapFromEntity(it) }
    }
}