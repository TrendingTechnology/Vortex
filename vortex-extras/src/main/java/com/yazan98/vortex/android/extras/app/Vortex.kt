package com.yazan98.vortex.android.extras.app

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.setThreadPolicy
import android.os.StrictMode.setVmPolicy
import androidx.appcompat.app.AppCompatDelegate
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.core.CrashlyticsCore
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import com.facebook.stetho.dumpapp.DumperPlugin
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.yazan98.vortex.android.extras.VortexViewModelPlatform
import com.yazan98.vortex.android.extras.VortexViperPlatform
import com.yazan98.vortex.android.extras.keys.ImageLoaders
import com.yazan98.vortex.android.extras.keys.VortexArchitecture
import com.yazan98.vortex.android.extras.keys.VortexLogger
import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexBlockedException
import com.yazan98.vortex.base.platform.BaseVortex
import io.fabric.sdk.android.Fabric
import leakcanary.LeakSentry
import timber.log.Timber

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 2:36 AM
 */

object Vortex : IVortex {

    private lateinit var architecture: VortexArchitecture

    override fun registerArchitecture(architecture: VortexArchitecture): Vortex {
        this.architecture = architecture
        return this
    }

    override fun startLeakCanary(isDebugEnabled: Boolean): Vortex {
        LeakSentry.config = LeakSentry.config.copy(watchFragmentViews = true)
        return this
    }

    override fun registerStrictMode(isDebugEnabled: Boolean): Vortex {
        setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build()
        )

        setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
        return this
    }

    override fun registerImageLoader(loader: ImageLoaders, application: Application): Vortex {
        when (loader) {
            ImageLoaders.FRESCO -> {
                Fresco.initialize(application)
            }

            ImageLoaders.GLIDE -> {
                //TODO: Implement this
            }

            ImageLoaders.PICASSO -> {
                Picasso.setSingletonInstance(
                    Picasso.Builder(application)
                        .downloader(OkHttp3Downloader(application))
                        .build()
                )
            }

        }
        return this
    }

    override fun registerApplicationLogger(logger: VortexLogger, isDebugEnabled: Boolean): Vortex {
        if (isDebugEnabled) {
            when (logger) {
                VortexLogger.TIMBER -> Timber.plant(Timber.DebugTree())
                VortexLogger.VORTEX -> {
                    //TODO: Implement this when make logger
                }
            }
        }
        return this
    }

    override fun registerFirebase(application: Application): Vortex {
        FirebaseApp.initializeApp(application)
        FirebaseAnalytics.getInstance(application)
        return this
    }

    override fun registerCrashLytics(application: Application, isDebugEnabled: Boolean): Vortex {
        Fabric.with(
            application, Crashlytics.Builder()
                .core(
                    CrashlyticsCore.Builder()
                        .disabled(isDebugEnabled)
                        .build()
                )
                .answers(Answers())
                .build()
        )
        return this
    }

    override fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): Vortex {
        Thread.currentThread().uncaughtExceptionHandler = handler
        return this
    }

    override fun registerStethoWithDumpApp(application: Application, plugin: DumperPlugin): Vortex {
        Stetho.initialize(
            Stetho.newInitializerBuilder(application)
                .enableDumpapp {
                    Stetho.DefaultDumperPluginsBuilder(application)
                        .provide(plugin)
                        .finish()
                }
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(application))
                .build()
        )
        return this
    }

    override fun registerOfflineCachingFirebaseDatabase(application: Application): Vortex {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        return this
    }

    override fun registerFirebaseDatabaseFreshData(path: String): Vortex {
        val scoresRef = FirebaseDatabase.getInstance().getReference(path)
        scoresRef.keepSynced(true)
        return this
    }

    override fun registerCompatVector(): Vortex {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        return this
    }

    override fun registerStetho(application: Application): Vortex {
        Stetho.initializeWithDefaults(application)
        return this
    }

    override fun build(): Vortex {
        if (::architecture.isInitialized) {
            when (architecture) {
                VortexArchitecture.VIEW_MODEL -> {
                    BaseVortex().initPlatform()
                    VortexViewModelPlatform()
                }

                VortexArchitecture.VIPER -> {
                    BaseVortex().initPlatform()
                    VortexViperPlatform()
                }
            }
        } else {
            throw VortexBlockedException(
                VortexConsts.ARCHITECTURE_NOT_INITIALIZED
            )
        }
        return this
    }

}
