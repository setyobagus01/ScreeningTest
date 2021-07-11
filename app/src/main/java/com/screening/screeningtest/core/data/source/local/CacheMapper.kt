package com.screening.screeningtest.core.data.source.local

import com.screening.screeningtest.core.data.utils.EntityMapper
import com.screening.screeningtest.core.domain.model.Guest
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<GuestCacheEntity, Guest> {
    override fun mapFromEntity(entity: GuestCacheEntity): Guest {
        return Guest(
            id = entity.id,
            name = entity.name,
            birthDate = entity.birthDate,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Guest): GuestCacheEntity {
        return GuestCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            birthDate = domainModel.birthDate,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<GuestCacheEntity>): List<Guest> {
        return entities.map { mapFromEntity(it) }
    }


}