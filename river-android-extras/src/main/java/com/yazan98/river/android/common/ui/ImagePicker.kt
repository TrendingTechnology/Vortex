
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
package com.yazan98.river.android.common.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.yazan98.river.android.common.RiverPermissions


/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 6:38 PM
 */

object ImagePicker {

    fun checkStoragePermission(context: Context): Boolean {
        return RiverPermissions.isPermissionGenerated(
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
                selectedImage,
                filePathColumn, null, null, null
            )

            cursor.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            image.setEnabled(true)
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
                selectedImage,
                filePathColumn, null, null, null
            )

            cursor.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            image.setEnabled(true)
            cursor.close()
            callback.onSuccessImagePicker(selectedImage.toString())
        } else {
            callback.onErrorImagePath("ImagePickerError")
        }
    }

    fun onImageResult(
        context: Context, requestCode: Int, resultCode: Int,
        data: Intent?, callback: ImagePickerListener) {
        if (data != null) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = context.contentResolver.query(
                selectedImage,
                filePathColumn, null, null, null
            )
            cursor.moveToFirst()
            cursor.close()
            callback.onSuccessImagePicker(selectedImage.toString())
        } else {
            callback.onErrorImagePath("ImagePickerError")
        }
    }

}
