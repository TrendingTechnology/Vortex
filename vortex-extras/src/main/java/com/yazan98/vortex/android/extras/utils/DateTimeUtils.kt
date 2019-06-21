package com.yazan98.vortex.android.extras.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:05 PM
 */

object DateTimeUtils {

    /**
     * "yyyy.MM.dd G 'at' HH:mm:ss z" ---- 2001.07.04 AD at 12:08:56 PDT
     * "hh 'o''clock' a, zzzz" ----------- 12 o'clock PM, Pacific Daylight Time
     * "EEE, d MMM yyyy HH:mm:ss Z"------- Wed, 4 Jul 2001 12:08:56 -0700
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"------- 2001-07-04T12:08:56.235-0700
     * "yyMMddHHmmssZ"-------------------- 010704120856-0700
     * "K:mm a, z" ----------------------- 0:08 PM, PDT
     * "h:mm a" -------------------------- 12:08 PM
     * "EEE, MMM d, ''yy" ---------------- Wed, Jul 4, '01
     */
    fun getTimeAndDate(pattern: String): String {
        @SuppressLint("SimpleDateFormat")
        val df = SimpleDateFormat(pattern)
        return df.format(Calendar.getInstance().time)
    }

    fun getDateFromTimestamp(timestamp: Long): String {
        val date = Date(timestamp)
        return date.toString()
    }

    fun getDate(date: Date): String {
        return "${date.day}/${date.month}/${date.year}"
    }

}