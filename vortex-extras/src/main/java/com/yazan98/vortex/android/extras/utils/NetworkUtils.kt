package com.yazan98.vortex.android.extras.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:13 PM
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