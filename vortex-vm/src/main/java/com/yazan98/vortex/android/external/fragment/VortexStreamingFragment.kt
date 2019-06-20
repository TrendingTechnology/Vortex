package com.yazan98.vortex.android.external.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.state.NetworkState
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.VortexNetworkViewModel
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:30 PM
 */

abstract class VortexStreamingFragment<V : VortexRxView, VM : VortexNetworkViewModel<V>> :
    VortexNetworkFragment<V, VM>() {

    private val repository: RxRequestRepository by lazy {
        RxRequestRepository()
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository.addRequest(
            internetListener(activity!!).subscribe {
                if (it) {
                    onNetworkState(NetworkState.CONNECTED)
                } else {
                    onNetworkState(NetworkState.NOT_CONNECTED)
                }
            }
        )

    }

    private fun internetListener(context: Context): Observable<Boolean> {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected)
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.clearAllRequests()
    }

    override fun onDetach() {
        super.onDetach()
        repository.clearAllRequests()
    }

    protected abstract fun onNetworkState(newState: NetworkState)

}
