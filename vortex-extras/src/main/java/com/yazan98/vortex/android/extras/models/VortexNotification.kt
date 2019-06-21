package com.yazan98.vortex.android.extras.models

import android.content.Context

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:02 PM
 */

data class VortexNotification(
    val title: String,
    val content: String,
    val context: Context,
    val smallIcon: Int,
    val largeIcon: Int,
    val reqCode: Int,
    val targetClass: Class<*>
)
