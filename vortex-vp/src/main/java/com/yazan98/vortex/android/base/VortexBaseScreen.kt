package com.yazan98.vortex.android.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.yazan98.vortex.base.view.VortexRxView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:37 PM
 */

abstract class VortexBaseScreen : AppCompatActivity(), VortexRxView {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initScreen()
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

}
