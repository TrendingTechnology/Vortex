
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


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.FROYO
import android.view.Surface
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 6:27 PM
 */

object ScreenOrientationUtils {

    fun setPortraitOpientationScreen(context: AppCompatActivity) {
        context.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun setLandscapeOrientationScreen(context: AppCompatActivity) {
        context.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    fun lockOrientationLandscape(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
    }

    fun lockOrientationPortrait(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    @SuppressLint("ObsoleteSdkInt", "WrongConstant")
    fun lockOrientation(activity: AppCompatActivity) {
        val orientation = activity.resources.configuration.orientation
        val rotation = (activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            .rotation

        var SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8
        var SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9

        // Build.VERSION.SDK_INT <= Build.VERSION_CODES.FROYO
        if (SDK_INT > FROYO) {
            SCREEN_ORIENTATION_REVERSE_LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            SCREEN_ORIENTATION_REVERSE_PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
        } else if (rotation == Surface.ROTATION_180 || rotation == Surface.ROTATION_270) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity.requestedOrientation = SCREEN_ORIENTATION_REVERSE_PORTRAIT
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                activity.requestedOrientation = SCREEN_ORIENTATION_REVERSE_LANDSCAPE
            }
        }
    }

    fun unlockOrientation(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
    }

}
