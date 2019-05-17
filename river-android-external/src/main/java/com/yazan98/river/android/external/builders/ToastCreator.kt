package com.yazan98.river.android.external.builders

import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.yazan98.river.android.external.R

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
 * Date : 5/14/2019
 * Time : 10:53 PM
 */

object ToastCreator {

    fun showShortToast(context: FragmentActivity, messageId: Int) {
        Toast.makeText(context, context.resources.getString(messageId), Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(context: FragmentActivity, messageId: Int) {
        Toast.makeText(context, context.resources.getString(messageId), Toast.LENGTH_LONG).show()
    }

    fun showShortToast(context: FragmentActivity, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(context: FragmentActivity, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showSuccessToast(context: FragmentActivity, messageId: Int) {
        createCustomToast(context, messageId, R.color.green)
    }

    fun showErrorToast(context: FragmentActivity, messageId: Int) {
        createCustomToast(context, messageId, R.color.red)
    }

    private fun createCustomToast(context: FragmentActivity, messageId: Int, colorId: Int) {
        val toast = Toast(context)
        val toastView = toast.view
        val toastMessage = toastView.findViewById<TextView>(R.id.ToastMessage)
        toastMessage.text = context.resources.getString(messageId)
        toast.duration = Toast.LENGTH_SHORT
        toastMessage.gravity = Gravity.CENTER
        toastMessage.setBackgroundColor(context.resources.getColor(colorId))
        toast.show()
    }

}
