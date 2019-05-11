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
package com.yazan98.river.android.common

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 12:22 PM
 */

object RiverPermissions {

    private var requestCode: Int = 0

    fun isPermissionGenerated(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission(context: AppCompatActivity, requestCode: Int, permission: String) {
        this.requestCode = requestCode
        ActivityCompat.requestPermissions(
            context,
            arrayOf(permission),
            requestCode
        )
    }

    fun requestMultiPermission(context: Context, permissionNumbers: Int, vararg permission: String) {
        if (!hasPermissions(context, *permission)) {
            ActivityCompat.requestPermissions(context as Activity, permission, permissionNumbers)
        }
    }

    fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray,
        callback: PermissionCallback
    ) {
        if (requestCode == this.requestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callback.onPermissionSuccess()
            } else {
                callback.onPermissionFailed()
            }
        }
    }

    fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
        if (context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

    interface PermissionCallback {
        fun onPermissionSuccess()

        fun onPermissionFailed()
    }

}
