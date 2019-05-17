package com.yazan98.river.web.extras.app

import org.springframework.boot.SpringApplication
import org.springframework.core.env.Environment


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
 * Time : 3:13 PM
 */

object RiverWebAppConfiguration {

    private lateinit var profiles: Array<String>
    private var urls: ArrayList<String> = ArrayList(3)
    private lateinit var environment: Environment
    private var runtime: Runtime = Runtime.getRuntime()
    private lateinit var appDetails: ApplicationDetails

    fun withApplication(targetClass: Class<*>, args: Array<String>): RiverWebAppConfiguration {
        val app = SpringApplication(targetClass)
        environment = app.run(args[0]).environment
        return this
    }

    fun withApplicationDetailsBuilder(): RiverWebAppConfiguration {
        appDetails = ApplicationDetails(
            environment.getProperty("spring.application.name", ""),
            environment.getProperty("server.port", "8090"),
            environment.getProperty("server.address", "localhost"),
            environment.getProperty("server.servlet.context-path", "https"),
            getBaseUrl(),
            getSwaggerPageUrl(),
            getHystrixDashboardUrl(),
            environment.activeProfiles
        )
        return this
    }

    fun withPrintApplicationDetails(): RiverWebAppConfiguration {
        println(
            "\n------------------------------- ${appDetails.ApplicationName} -------------------------------\n" +
                    "--------- Server Address : ${appDetails.Address} \n" +
                    "--------- Server Port : ${appDetails.serverPort} \n" +
                    "--------- Context Path : ${appDetails.contextPath} \n" +
                    "--------- Base Url : ${appDetails.baseUrl} \n" +
                    "--------- Swagger Url Page : ${appDetails.swaggerPage} \n" +
                    "--------- Hystrix Url Page : ${appDetails.hystrixDashboard} \n" +
                    "--------- Profile Active : ${appDetails.profiles[0]} \n"
        )
        return this
    }

    fun withStartupPages(urls: ArrayList<String>): RiverWebAppConfiguration {
        for (url in urls) {
            if (url != getSwaggerPageUrl() || url != getHystrixDashboardUrl())
                this.urls.add(url)
        }
        return this
    }

    fun build(): RiverWebAppConfiguration {
        startPage(getSwaggerPageUrl())
        startPage(getHystrixDashboardUrl())
        for (link in this.urls) {
            startPage(link)
        }
        return this
    }

    private fun startPage(url: String) {
        runtime.exec("rundll32 url.dll,FileProtocolHandler $url")
    }

    private fun getBaseUrl(): String {
        return environment.getProperty("server.servlet.context-path", "https") +
                "://${environment.getProperty("server.address", "localhost")}}" +
                ":${environment.getProperty("server.port", "8090")}/"
    }

    private fun getSwaggerPageUrl(): String {
        return "${getBaseUrl()}/swagger-ui.html"
    }

    private fun getHystrixDashboardUrl(): String {
        return "${getBaseUrl()}/hystrix"
    }
}
