package com.yazan98.vortex.vm.base

import androidx.lifecycle.MutableLiveData
import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexBlockedException
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.base.VortexViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import java.lang.ref.WeakReference

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:51 PM
 */

class VortexNetworkViewModel<V : VortexRxView> : VortexViewModel.NetworkViewModel<V , MutableLiveData<State>>() {

    private var view: WeakReference<V>? = null
    private val stateObserver: MutableLiveData<State> by lazy { MutableLiveData<State>() }
    private val repository: RxRequestRepository by lazy {
        RxRequestRepository()
    }

    override fun attachView(view: V) {
        this.view = WeakReference(view)
    }

    @Throws(VortexBlockedException::class)
    override fun getView(): V {
        if (this.view!!.get() != null) {
            return view!!.get()!!
        } else {
            throw VortexBlockedException(
                VortexConsts.EMPTY_VIEW_VM
            )
        }
    }

    override fun detatchView() {
        this.view!!.clear()
        this.view = null
    }

    override fun destroyPresenter() {
        this.repository.clearAllRequests()
        detatchView()
    }

    override fun addRxRequest(request: Disposable) {
        this.repository.addRequest(request)
    }

    override fun getStateHandler(): MutableLiveData<State> {
        return stateObserver
    }

    override fun acceptNewState(newState: State) {
        synchronized(newState) {
            stateObserver.postValue(newState)
        }
    }

}
