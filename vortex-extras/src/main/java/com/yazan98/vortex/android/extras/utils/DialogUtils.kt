package com.yazan98.vortex.android.extras.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.PopupMenu

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:06 PM
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