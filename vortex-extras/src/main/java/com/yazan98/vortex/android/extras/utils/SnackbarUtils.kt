package com.yazan98.vortex.android.extras.utils

import android.content.res.Resources
import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:15 PM
 */

object SnackbarUtils {

    fun showSnackbarMessage(message: Int, view: View, resources: Resources, duration: Int) {
        Snackbar.make(view, resources.getString(message), duration).show()
    }

    fun showSnackbarWithAction(
        message: Int, view: View, resources: Resources, duration: Int,
        actionKey: Int, listener: View.OnClickListener
    ) {
        Snackbar.make(view, resources.getString(message), duration)
            .setAction(resources.getString(actionKey), listener)
            .show()
    }

    class SnackBarBuilder {

        private var view: View? = null
        private var message: Int = 0
        private var actionKey: Int = 0
        private var resources: Resources? = null
        private var textColorEnabled: Boolean = false
        private var backgroundColorEnabled: Boolean = false
        private var backgroundColor: Int = 0
        private var textColor: Int = 0
        private var listener: View.OnClickListener? = null
        private var snackbar: Snackbar? = null
        private var isActionEnabled: Boolean = false
        private var duration: Int = 0

        fun withActionText(color: Int): SnackBarBuilder {
            this.textColorEnabled = true
            this.textColor = color
            return this
        }

        fun withBackgroundColor(backgroundColor: Int): SnackBarBuilder {
            this.backgroundColor = backgroundColor
            this.backgroundColorEnabled = true
            return this
        }

        fun withRootView(view: View): SnackBarBuilder {
            this.view = view
            return this
        }

        fun withMessage(message: Int): SnackBarBuilder {
            this.message = message
            return this
        }

        fun withResources(resources: Resources): SnackBarBuilder {
            this.resources = resources
            return this
        }

        fun withAction(actionKey: Int, listener: View.OnClickListener): SnackBarBuilder {
            this.isActionEnabled = true
            this.actionKey = actionKey
            this.listener = listener
            return this
        }

        fun withDuration(duration: Int): SnackBarBuilder {
            this.duration = duration
            return this
        }

        fun build(): SnackBarBuilder {
            snackbar = Snackbar.make(view!!, resources!!.getString(message), duration)
            snackbar!!.setActionTextColor(textColor)
            if (isActionEnabled) {
                snackbar!!.setAction(actionKey, listener)
            }

            if (backgroundColorEnabled) {
                val result = snackbar!!.getView()
                result.setBackgroundColor(backgroundColor)
            }

            snackbar!!.show()
            return SnackBarBuilder()
        }

        companion object {

            fun createBuilder(): SnackBarBuilder {
                return SnackBarBuilder()
            }
        }
    }

}
