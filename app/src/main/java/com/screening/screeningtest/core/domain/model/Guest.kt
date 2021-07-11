package com.screening.screeningtest.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Guest (
    val id: Int,
    val name: String,
    val birthDate: String,
    val image: String,
): Parcelable