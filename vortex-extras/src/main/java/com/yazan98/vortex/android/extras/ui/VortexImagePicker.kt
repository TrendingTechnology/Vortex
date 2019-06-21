package com.yazan98.vortex.android.extras.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.yazan98.vortex.android.extras.VortexPermissions
import com.yazan98.vortex.android.extras.listeners.ImagePickerListener

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:29 PM
 */

object VortexImagePicker {

    fun checkStoragePermission(context: Context): Boolean {
        return VortexPermissions.isPermissionGenerated(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    fun takeImage(context: FragmentActivity, reqCode: Int) {
        val i: Intent = Intent(
            Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        context.startActivityForResult(i, reqCode)
    }

    fun takeImage(context: FragmentActivity, reqCode: Int, callback: ImagePickerListener) {
        if (checkStoragePermission(context)) {
            val i: Intent = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            context.startActivityForResult(i, reqCode)
        } else {
            callback.onErrorImagePath("StoragePermissionError")
        }
    }

    fun onImageResult(context: Context, requestCode: Int, resultCode: Int, data: Intent?, image: ImageView) {
        if (data != null) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = context.contentResolver.query(
                selectedImage!!,
                filePathColumn, null, null, null
            )

            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            image.isEnabled = true
            cursor.close()
        } else {
            Toast.makeText(context, "Something Error , Try Again!!", Toast.LENGTH_SHORT).show()
        }
    }

    fun onImageResult(
        context: Context, requestCode: Int, resultCode: Int,
        data: Intent?, image: ImageView, callback: ImagePickerListener
    ) {
        if (data != null) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = context.contentResolver.query(
                selectedImage!!,
                filePathColumn, null, null, null
            )

            cursor?.moveToFirst()
            val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
            val picturePath = cursor?.getString(columnIndex!!)
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            image.isEnabled = true
            cursor?.close()
            callback.onSuccessImagePicker(selectedImage.toString())
        } else {
            callback.onErrorImagePath("ImagePickerError")
        }
    }

    fun onImageResult(
        context: Context, requestCode: Int, resultCode: Int,
        data: Intent?, callback: ImagePickerListener
    ) {
        if (data != null) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = context.contentResolver.query(
                selectedImage!!,
                filePathColumn, null, null, null
            )
            cursor?.moveToFirst()
            cursor?.close()
            callback.onSuccessImagePicker(selectedImage.toString())
        } else {
            callback.onErrorImagePath("ImagePickerError")
        }
    }

}
