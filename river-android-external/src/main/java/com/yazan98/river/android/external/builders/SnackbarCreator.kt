package com.yazan98.river.android.external.builders

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
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
 * Time : 11:11 PM
 */

object SnackbarCreator {

    fun showShortSnackbar(context: FragmentActivity, messageId: Int, view: View) {
        Snackbar.make(view, context.resources.getText(messageId), Snackbar.LENGTH_SHORT).show()
    }

    fun showLongSnackbar(context: FragmentActivity, messageId: Int, view: View) {
        Snackbar.make(view, context.resources.getText(messageId), Snackbar.LENGTH_LONG).show()
    }

    fun createSuccessSnakebar(context: FragmentActivity, messageId: Int, view: View) {
        createCustomSnackbar(context, messageId, view, R.color.green)
    }

    fun createFailedSnackbar(context: FragmentActivity, messageId: Int, view: View) {
        createCustomSnackbar(context, messageId, view, R.color.red)
    }

    fun createCustomSnackbar(context: FragmentActivity, messageId: Int, view: View, backgroundColor: Int) {
        val snackbar: Snackbar = Snackbar.make(view, context.resources.getText(messageId), Snackbar.LENGTH_SHORT)
        val snackBarView = snackbar.view
        snackBarView.setBackgroundColor(context.resources.getColor(backgroundColor))
        val textView = snackBarView.findViewById<View>(R.id.ToastMessage) as TextView
        textView.setTextColor(context.resources.getColor(R.color.wi))
        snackbar.show()
    }

}
