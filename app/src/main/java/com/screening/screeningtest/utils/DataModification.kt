package com.screening.screeningtest.utils

import java.text.SimpleDateFormat
import java.util.*

object DataModification {
    fun dayConverter(date: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(date)
        val calendar = Calendar.getInstance()
        if (dateFormat != null) {
            calendar.time = dateFormat
        }

        return calendar.get(Calendar.DAY_OF_MONTH).toString()
    }


}