package com.yazan98.vortex.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.yazan98.vortex.android.base.VortexBaseFragment
import com.yazan98.vortex.base.presenter.presenters.VortexRxPresenter
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.view.VortexRxView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:29 PM
 */

abstract class VortexNetworkFragment<V : VortexRxView, VM : VortexRxPresenter<V>> : VortexBaseFragment() {

    private val repository: RxRequestRepository by lazy {
        RxRequestRepository()
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository.addRequest(
            getPresenter().getStateHandler().subscribe {
                onNewState(it)
            }
        )
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        repository.clearAllRequests()
    }

    @CallSuper
    override fun onDetach() {
        super.onDetach()
        repository.clearAllRequests()
    }

    protected abstract fun getPresenter(): VM

}
