package com.yazan98.vortex.android.extras.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:13 PM
 */
object RecyclerViewUtils {

    fun highCacheRecyclerView(recyclerView: RecyclerView, count: Int, isItemsSameSize: Boolean) {
        recyclerView.setHasFixedSize(isItemsSameSize)
        recyclerView.setItemViewCacheSize(count)
        recyclerView.isDrawingCacheEnabled = true
        recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
    }

    fun withLinerLayout(recyclerView: RecyclerView?, context: Context?) {
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }

    fun withGridLayout(recyclerView: RecyclerView, context: Context, rowItems: Int) {
        recyclerView.layoutManager = GridLayoutManager(context, rowItems)
    }

}
