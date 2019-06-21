package com.yazan98.vortex.android.extras.ui

import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:27 PM
 */

abstract class VortexBaseSingleRecyclerViewAdapter<VH : RecyclerView.ViewHolder , Data> : VortexBaseAdapter<VH>() {

    lateinit var data: ArrayList<Data>

    override fun getItemCount(): Int {
        return data.size
    }

}
