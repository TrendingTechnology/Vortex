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
 * Time : 2:34 PM
 */

abstract class RiverFirebaseConfiguration : FirebaseConfigure {

    private lateinit var serviceAccount: FileInputStream

    @Bean
    override fun buildFirebaseApp(): FirebaseApp {
        val firebaseJsonFile: String = "{" +
                "  \"type\": ${getApplicationDetails().type}," +
                "  \"project_id\": ${getApplicationDetails().projectId} ," +
                "  \"private_key_id\": ${getApplicationDetails().privateKeyId},\n" +
                "  \"private_key\": ${getApplicationDetails().privateKey}," +
                "  \"client_email\": ${getApplicationDetails().ClientEmail}," +
                "  \"client_id\": ${getApplicationDetails().ClientId}," +
                "  \"auth_uri\": ${getApplicationDetails().authUri}," +
                "  \"token_uri\": ${getApplicationDetails().tokenUri}," +
                "  \"auth_provider_x509_cert_url\": ${getApplicationDetails().authProviderx509}," +
                "  \"client_x509_cert_url\": ${getApplicationDetails().Clientx509}" +
                "}"

        serviceAccount = FileInputStream(firebaseJsonFile)

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl(getDatabaseUrl())
            .build()

        try {
            FirebaseApp.initializeApp(options)
            println("Firebase Configuration Done!!!")
        } catch (ex: Exception) {
            println("Something Wrong With Firebase Configuration : ${ex.message}")
            ex.printStackTrace()
        }

        return FirebaseApp.getInstance()
    }

    protected abstract fun getDatabaseUrl(): String
}
