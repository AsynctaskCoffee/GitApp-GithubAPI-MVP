package com.asynclabs.githubpersonalapplication.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class SimpleTimeUtils {
    fun calculateTimeDifference(date: String): String {
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val from =
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
                val today = LocalDate.now()
                val period = Period.between(from, today)
                return "Published at " + period.days + " days ago"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Published at $date"
    }
}