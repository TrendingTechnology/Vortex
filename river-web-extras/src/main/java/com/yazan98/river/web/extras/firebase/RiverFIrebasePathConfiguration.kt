package com.yazan98.river.web.extras.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import java.io.FileInputStream



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

/**
 * Created By : Yazan Tarifi
 * Date : 5/17/2019
 * Time : 2:47 PM
 */

abstract class RiverFIrebasePathConfiguration {

    private lateinit var serviceAccount: FileInputStream
    private lateinit var options: FirebaseOptions

    @Bean
    fun buildFirebaseApp(): FirebaseApp {
        serviceAccount = FileInputStream(getJsonPath())
        options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl(getDatabaseUrl())
            .build()

        FirebaseApp.initializeApp(options)
        return FirebaseApp.getInstance()
    }

    protected abstract fun getJsonPath(): String
    protected abstract fun getDatabaseUrl(): String

}
