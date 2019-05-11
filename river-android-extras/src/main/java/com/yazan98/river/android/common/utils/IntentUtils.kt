
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
package com.yazan98.river.android.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 12:24 PM
 */

object IntentUtils {

    fun startScreen(context: FragmentActivity, targetClass: Class<*>, isFinishedEnabled: Boolean) {
        context.startActivity(Intent(context, targetClass))
        if (isFinishedEnabled)
            context.finish()
    }

    fun startWebPage(url: String, context: Context) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    /**
     * <uses-permission android:name="android.permission.CALL_PHONE" />
     */
    fun callPhoneNumber(phoneNumber: String, context: Context) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(intent)
    }


}