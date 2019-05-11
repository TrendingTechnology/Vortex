
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
import android.content.res.Configuration
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE

/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 21:09
 */

object ScreenUtils {

    private var configuration: Configuration? = null

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK >= SCREENLAYOUT_SIZE_LARGE
    }

    fun hasSmallScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_SMALL
    }

    fun hasNormalScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_NORMAL
    }

    fun hasLargeScreen(context: Context): Boolean {
        return getScreenSize(context) == SCREENLAYOUT_SIZE_LARGE
    }

    private fun getScreenSize(context: Context): Int {
        configuration = context.resources.configuration
        return configuration!!.screenLayout and SCREENLAYOUT_SIZE_MASK
    }

}