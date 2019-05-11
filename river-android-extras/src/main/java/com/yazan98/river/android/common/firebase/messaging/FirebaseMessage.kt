
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
package com.yazan98.river.android.common.firebase.messaging

import android.content.Context

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 12:09 PM
 */

data class FirebaseMessage(
    val title: String,
    val content: String,
    val context: Context,
    val smallIcon: Int,
    val largeIcon: Int,
    val reqCode: Int,
    val targetClass: Class<*>
)
