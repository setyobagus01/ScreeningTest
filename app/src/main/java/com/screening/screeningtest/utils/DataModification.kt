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

    fun isPrimeNumber(str: String): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(str)
        val calendar = Calendar.getInstance()
        if (dateFormat != null) {
            calendar.time = dateFormat
        }
        val num = calendar.get(Calendar.MONTH)
        var isNotPrime = false
        if (num > 1) {
            for (i in 2 until num) {
                if (num % i == 0) {
                    isNotPrime = true
                    break
                }
            }
        }

        return if (isNotPrime) {
            "is Not Prime Number"
        } else {
            "is Prime Number"
        }
    }


}