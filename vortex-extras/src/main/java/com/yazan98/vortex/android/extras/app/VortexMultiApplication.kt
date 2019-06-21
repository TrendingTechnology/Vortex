package com.yazan98.vortex.android.extras.app

import android.content.Context
import androidx.annotation.CallSuper
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 2:47 AM
 */

open class VortexMultiApplication : MultiDexApplication() {

    @CallSuper
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

}
