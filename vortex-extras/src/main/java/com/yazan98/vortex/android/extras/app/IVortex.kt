package com.yazan98.vortex.android.extras.app

import android.app.Application
import com.facebook.stetho.dumpapp.DumperPlugin
import com.yazan98.vortex.android.extras.keys.VortexArchitecture
import com.yazan98.vortex.android.extras.keys.ImageLoaders
import com.yazan98.vortex.android.extras.keys.VortexLogger

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 2:38 AM
 */
interface IVortex {

    /**
     * This Register Will Configure Platform Depends on how you will use the library
     */
    fun registerArchitecture(architecture: VortexArchitecture): Vortex

    fun startLeakCanary(isDebugEnabled: Boolean): Vortex

    fun registerStrictMode(isDebugEnabled: Boolean): Vortex

    fun registerImageLoader(loader: ImageLoaders, application: Application): Vortex

    fun registerApplicationLogger(logger: VortexLogger, isDebugEnabled: Boolean): Vortex

    fun registerFirebase(application: Application): Vortex

    fun registerCrashLytics(application: Application, isDebugEnabled: Boolean): Vortex

    fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): Vortex

    fun registerStethoWithDumpApp(application: Application, plugin: DumperPlugin): Vortex

    fun registerOfflineCachingFirebaseDatabase(application: Application): Vortex

    fun registerFirebaseDatabaseFreshData(path: String): Vortex

    fun registerCompatVector(): Vortex

    fun registerStetho(application: Application): Vortex

    fun build(): Vortex

}
