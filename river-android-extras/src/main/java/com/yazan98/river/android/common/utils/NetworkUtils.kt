
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
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager


/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 21:05
 */

object NetworkUtils {

    private var connectivityManager: ConnectivityManager? = null
    private var nwInfo: NetworkInfo? = null
    private var cm: ConnectivityManager? = null

    @SuppressLint("MissingPermission")
    fun isNetworkConnection(context: Context): Boolean {
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val nwInfo = connectivityManager!!.activeNetworkInfo
        return nwInfo != null && nwInfo.isConnectedOrConnecting
    }

    fun isConnectedFast(context: Context): Boolean {
        nwInfo = getNetworkInfo(context)
        return nwInfo != null && nwInfo!!.isConnected && isConnectionFast(nwInfo!!.type, nwInfo!!.subtype)
    }

    private fun getNetworkInfo(context: Context): NetworkInfo {
        cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo
    }

    private fun isConnectionFast(type: Int, subType: Int): Boolean {
        return if (type == ConnectivityManager.TYPE_WIFI) {
            true
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            when (subType) {
                TelephonyManager.NETWORK_TYPE_1xRTT
                -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_CDMA
                -> false // ~ 14-64 kbps
                TelephonyManager.NETWORK_TYPE_EDGE
                -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_0
                -> true // ~ 400-1000 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_A
                -> true // ~ 600-1400 kbps
                TelephonyManager.NETWORK_TYPE_GPRS
                -> false // ~ 100 kbps
                TelephonyManager.NETWORK_TYPE_HSDPA
                -> true // ~ 2-14 Mbps
                TelephonyManager.NETWORK_TYPE_HSPA
                -> true // ~ 700-1700 kbps
                TelephonyManager.NETWORK_TYPE_HSUPA
                -> true // ~ 1-23 Mbps
                TelephonyManager.NETWORK_TYPE_UMTS
                -> true // ~ 400-7000 kbps
                TelephonyManager.NETWORK_TYPE_EHRPD // API level 11
                -> true // ~ 1-2 Mbps
                TelephonyManager.NETWORK_TYPE_EVDO_B // API level 9
                -> true // ~ 5 Mbps
                TelephonyManager.NETWORK_TYPE_HSPAP // API level 13
                -> true // ~ 10-20 Mbps
                TelephonyManager.NETWORK_TYPE_IDEN // API level 8
                -> false // ~25 kbps
                TelephonyManager.NETWORK_TYPE_LTE // API level 11
                -> true // ~ 10+ Mbps
                // Unknown
                TelephonyManager.NETWORK_TYPE_UNKNOWN -> false
                else -> false
            }
        } else {
            false
        }
    }
}