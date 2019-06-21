package com.yazan98.vortex

import com.yazan98.vortex.android.extras.app.Vortex
import com.yazan98.vortex.android.extras.app.VortexMultiApplication
import com.yazan98.vortex.android.extras.keys.VortexArchitecture
import com.yazan98.vortex.android.extras.keys.ImageLoaders
import com.yazan98.vortex.android.extras.keys.VortexLogger

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 3:15 AM
 */

class VortexApp : VortexMultiApplication() , Thread.UncaughtExceptionHandler {

    override fun onCreate() {
        super.onCreate()

        /**
         * Vortex Application Configuration
         */
        Vortex
            .registerApplicationLogger(VortexLogger.TIMBER , BuildConfig.DEBUG)
            .registerArchitecture(VortexArchitecture.VIEW_MODEL)
            .registerImageLoader(ImageLoaders.FRESCO , this)
            .registerImageLoader(ImageLoaders.PICASSO , this)
            .registerCrashLytics(this , BuildConfig.DEBUG)
            .registerExceptionHandler(this)
            .registerFirebase(this)
            .registerOfflineCachingFirebaseDatabase(this)
            .registerStrictMode(BuildConfig.DEBUG)
            .startLeakCanary(BuildConfig.DEBUG)
            .registerStetho(this)
            .registerCompatVector()
            .build()

    }

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        // Common Dialog For Any UnExpected Error
    }

}
