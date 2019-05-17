package com.yazan98.river.web.extras.app

import java.io.Serializable


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
 * Time : 3:24 PM
 */

data class ApplicationDetails(
    val ApplicationName: String,
    val serverPort: String,
    val Address: String,
    val contextPath: String,
    val baseUrl: String,
    val swaggerPage: String,
    val hystrixDashboard: String,
    val profiles: Array<String>
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ApplicationDetails

        if (ApplicationName != other.ApplicationName) return false
        if (serverPort != other.serverPort) return false
        if (Address != other.Address) return false
        if (contextPath != other.contextPath) return false
        if (baseUrl != other.baseUrl) return false
        if (swaggerPage != other.swaggerPage) return false
        if (hystrixDashboard != other.hystrixDashboard) return false
        if (!profiles.contentEquals(other.profiles)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ApplicationName.hashCode()
        result = 31 * result + serverPort.hashCode()
        result = 31 * result + Address.hashCode()
        result = 31 * result + contextPath.hashCode()
        result = 31 * result + baseUrl.hashCode()
        result = 31 * result + swaggerPage.hashCode()
        result = 31 * result + hystrixDashboard.hashCode()
        result = 31 * result + profiles.contentHashCode()
        return result
    }


}
