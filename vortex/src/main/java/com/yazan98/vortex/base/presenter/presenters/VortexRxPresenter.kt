package com.yazan98.vortex.base.presenter.presenters

import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexViewException
import com.yazan98.vortex.base.presenter.VortexPresenter
import com.yazan98.vortex.base.rx.RxRequestRepository
import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexRxView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:47 PM
 */

open class VortexRxPresenter<V : VortexRxView> : VortexPresenter.NetworkPresenter<V>() {

    private var view: V? = null
    private val repo: RxRequestRepository by lazy { RxRequestRepository() }
    private val presenterStatue: BehaviorSubject<State> by lazy {
        BehaviorSubject.create<State>()
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun getView(): V {
        if (view != null)
            return this.view!!
        else
            throw VortexViewException(VortexConsts.EMPTY_VIEW)
    }

    override fun detatchView() {
        this.view = null
    }

    override fun destroyPresenter() {
        this.repo.clearAllRequests()
        this.detatchView()
    }

    override fun addRxRequest(request: Disposable) {
        this.repo.addRequest(request)
    }

    override fun getStateHandler(): Observable<State> {
        return this.presenterStatue
    }

    override fun acceptNewState(newState: State) {
        synchronized(newState) {
            this.presenterStatue.onNext(newState)
        }
    }
}
