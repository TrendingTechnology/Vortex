package com.yazan98.vortex.android.extras.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:27 PM
 */
abstract class VortexBaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    lateinit var context: Context

    protected abstract fun getLayoutRes(): Int

}