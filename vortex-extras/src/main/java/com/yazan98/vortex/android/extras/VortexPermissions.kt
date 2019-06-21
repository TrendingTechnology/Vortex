package com.yazan98.vortex.android.extras

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yazan98.vortex.android.extras.listeners.PermissionCallback

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:35 PM
 */
object VortexPermissions {

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

}