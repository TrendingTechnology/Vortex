
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
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.core.CrashlyticsCore
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import io.fabric.sdk.android.Fabric


/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 17:25
 */
class FirebaseApplicationConfiguration {

    fun initializeFirebase(application: Application): FirebaseApplicationConfiguration {
        FirebaseApp.initializeApp(application)
        FirebaseAnalytics.getInstance(application)
        return this
    }

    /**
     *  Disk Persistence
     *  Firebase apps automatically handle temporary network interruptions. Cached data is available while offline and Firebase resends any writes when network connectivity is restored.
     *  When you enable disk persistence, your app writes the data locally to the device so your app can maintain state while offline, even if the user or operating system restarts the app.
     *  You can enable disk persistence with just one line of code.
     */
    fun enableOfflineCachingFirebaseDatabase(): FirebaseApplicationConfiguration {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        return this
    }

    fun enableFirebaseDatabaseFreshData(path: String): FirebaseApplicationConfiguration {
        val scoresRef = FirebaseDatabase.getInstance().getReference(path)
        scoresRef.keepSynced(true)
        return this
    }

    fun enabledFirebaseCrashlyticsConfiguration(isEnabled: Boolean, application: Application):
            FirebaseApplicationConfiguration {
        Fabric.with(
            application, Crashlytics.Builder()
                .core(
                    CrashlyticsCore.Builder()
                        .disabled(isEnabled)
                        .build()
                )
                .answers(Answers())
                .build()
        )
        return this
    }
}
