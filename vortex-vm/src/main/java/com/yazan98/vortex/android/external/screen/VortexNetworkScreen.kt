package com.yazan98.vortex.android.external.screen

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import com.yazan98.vortex.android.external.base.VortexBaseScreen
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.VortexNetworkViewModel

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:14 PM
 */

abstract class VortexNetworkScreen<V : VortexRxView, VM : VortexNetworkViewModel<V>> : VortexBaseScreen() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().getStateHandler().observe(this, Observer {
            onNewState(it)
        })
    }

    protected abstract fun getViewModel(): VM

}
