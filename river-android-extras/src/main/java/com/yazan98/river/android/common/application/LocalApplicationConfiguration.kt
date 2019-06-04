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
package com.yazan98.river.android.common.application

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.os.StrictMode.setThreadPolicy
import android.os.StrictMode.setVmPolicy
import androidx.appcompat.app.AppCompatDelegate
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.DumperPluginsProvider
import com.facebook.stetho.Stetho
import com.facebook.stetho.dumpapp.DumperPlugin
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import com.uber.rxdogtag.RxDogTag
import com.uber.rxdogtag.autodispose.AutoDisposeConfigurer
import com.yazan98.river.android.common.RiverExceptionHandler
import leakcanary.LeakSentry
import timber.log.Timber


/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 17:25
 */

class LocalApplicationConfiguration {

    fun withLeakCanaryWithLeakSentry(): LocalApplicationConfiguration {
        LeakSentry.config = LeakSentry.config.copy(watchFragmentViews = false)
        return this
    }

    fun enableStrictMode(app: Application): LocalApplicationConfiguration {
        synchronized(app) {
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
        }
        return this
    }

    fun withPicassoCachingImages(application: Application): LocalApplicationConfiguration {
        Picasso.setSingletonInstance(
            Picasso.Builder(application)
                .downloader(OkHttp3Downloader(application))
                .build()
        )
        return this
    }

    fun withCompatVectorEnabled(): LocalApplicationConfiguration {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        return this
    }

    fun withCustomLoggingTimber(timber: Timber.Tree): LocalApplicationConfiguration {
        Timber.plant(timber)
        return this
    }

    fun withFrescoConfiguration(application: Application): LocalApplicationConfiguration {
        Fresco.initialize(application)
        return this
    }

    fun withTimberLogging(): LocalApplicationConfiguration {
        Timber.plant(Timber.DebugTree())
        return this
    }

    fun withStetho(application: Application): LocalApplicationConfiguration {
        Stetho.initializeWithDefaults(application)
        return this
    }

    fun withStethoWithDumpApp(application: Application, plugin: DumperPlugin): LocalApplicationConfiguration {
        Stetho.initialize(
            Stetho.newInitializerBuilder(application)
                .enableDumpapp(object : DumperPluginsProvider {
                    override fun get(): Iterable<DumperPlugin> {
                        return Stetho.DefaultDumperPluginsBuilder(application)
                            .provide(plugin)
                            .finish()
                    }
                })
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(application))
                .build()
        )
        return this
    }

    fun withApplicationExceptionHandler(handler: Thread.UncaughtExceptionHandler): LocalApplicationConfiguration {
        RiverExceptionHandler.getExceptionHandler(handler)
        return this
    }

    fun withRxJavaTracingOperations(): LocalApplicationConfiguration {
        RxDogTag.builder()
            .configureWith(AutoDisposeConfigurer::configure)
            .install()
        return this
    }

}
