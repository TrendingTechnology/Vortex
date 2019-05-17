
/**
 *    Copyright [2019] [Yazan Tarifi]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.yazan98.river.android.common.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 21:13
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
        @SuppressLint("SimpleDateFormat") val df = SimpleDateFormat(pattern)
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
