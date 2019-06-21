package com.yazan98.vortex.android.extras.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:09 PM
 */
object IntentUtils {

    fun startScreen(context: FragmentActivity, targetClass: Class<*>, isFinishedEnabled: Boolean) {
        context.startActivity(Intent(context, targetClass))
        if (isFinishedEnabled)
            context.finish()
    }

    fun startWebPage(url: String, context: Context) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    /**
     * <uses-permission android:name="android.permission.CALL_PHONE" />
     */
    fun callPhoneNumber(phoneNumber: String, context: Context) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(intent)
    }

}
