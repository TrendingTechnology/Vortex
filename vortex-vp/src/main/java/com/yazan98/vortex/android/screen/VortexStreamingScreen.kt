package com.yazan98.vortex.android.screen

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.annotation.CallSuper
import com.yazan98.vortex.base.presenter.presenters.VortexRxPresenter
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.state.NetworkState
import com.yazan98.vortex.base.view.VortexRxView
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:41 PM
 */

abstract class VortexStreamingScreen<V : VortexRxView, VM : VortexRxPresenter<V>> : VortexNetworkScreen<V, VM>() {

    private val repository: RxRequestRepository by lazy {
        RxRequestRepository()
    }

    @CallSuper
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository.addRequest(
            internetListener(this).subscribe {
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

    protected abstract fun onNetworkState(newState: NetworkState)

}
