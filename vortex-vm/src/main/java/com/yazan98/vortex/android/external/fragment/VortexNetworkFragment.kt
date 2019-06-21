package com.yazan98.vortex.android.external.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import com.yazan98.vortex.android.external.base.VortexBaseFragment
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.VortexNetworkViewModel

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:29 PM
 */
abstract class VortexNetworkFragment<V : VortexRxView, VM : VortexNetworkViewModel<V>> : VortexBaseFragment() {

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().getStateHandler().observe(this, Observer {
            onNewState(it)
        })
    }

    protected abstract fun getViewModel(): VM

}
