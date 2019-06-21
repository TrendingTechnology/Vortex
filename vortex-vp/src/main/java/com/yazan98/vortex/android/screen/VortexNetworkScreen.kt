package com.yazan98.vortex.android.screen

import android.os.Bundle
import androidx.annotation.CallSuper
import com.yazan98.vortex.android.base.VortexBaseScreen
import com.yazan98.vortex.base.presenter.presenters.VortexRxPresenter
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.view.VortexRxView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:14 PM
 */

abstract class VortexNetworkScreen<V : VortexRxView, VM : VortexRxPresenter<V>> : VortexBaseScreen() {

    private val repository: RxRequestRepository by lazy {
        RxRequestRepository()
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository.addRequest(
            getPresenter().getStateHandler().subscribe {
                onNewState(it)
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.clearAllRequests()
    }

    protected abstract fun getPresenter(): VM

}
