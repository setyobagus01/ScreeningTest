package com.screening.screeningtest.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    var id: Int,
    var name: String,
    var date: String,
    var image: String,
    var lat: String,
    var long: String,
    var description: String,
): Parcelable
