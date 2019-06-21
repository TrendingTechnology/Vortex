package com.yazan98.vortex.android.extras.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:15 PM
 */
object ScreenUtils {

    private var configuration: Configuration? = null

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK >= SCREENLAYOUT_SIZE_LARGE
    }

    fun hasSmallScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_SMALL
    }

    fun hasNormalScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_NORMAL
    }

    fun hasLargeScreen(context: Context): Boolean {
        return getScreenSize(context) == SCREENLAYOUT_SIZE_LARGE
    }

    private fun getScreenSize(context: Context): Int {
        configuration = context.resources.configuration
        return configuration!!.screenLayout and SCREENLAYOUT_SIZE_MASK
    }

}
