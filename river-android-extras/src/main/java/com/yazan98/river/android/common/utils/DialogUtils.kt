
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

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.PopupMenu

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 12:25 PM
 */

object DialogUtils {

    fun showDialog(
        context: Context, title: String, msg: String,
        positiveBtnText: String, negativeBtnText: String?,
        positiveBtnClickListener: DialogInterface.OnClickListener,
        negativeBtnClickListener: DialogInterface.OnClickListener
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setCancelable(true)
            .setPositiveButton(positiveBtnText, positiveBtnClickListener)
        if (negativeBtnText != null)
            builder.setNegativeButton(negativeBtnText, negativeBtnClickListener)
        val alert = builder.create()
        alert.show()
        return alert
    }

    fun showDialog(
        context: Context, title: String, msg: String,
        positiveBtnText: String
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setCancelable(true)
            .setPositiveButton(positiveBtnText) { dialog, which ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
        return alert
    }

    fun showPopupDialog(
        mContext: Context, view: View, resSelectors: Int,
        listener: PopupMenu.OnMenuItemClickListener
    ) {
        val popup = PopupMenu(mContext, view)
        val inflater = popup.menuInflater
        inflater.inflate(resSelectors, popup.menu)
        popup.setOnMenuItemClickListener(listener)
        popup.show()
    }


}
