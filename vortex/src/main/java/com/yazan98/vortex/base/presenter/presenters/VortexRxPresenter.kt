package com.yazan98.vortex.base.presenter.presenters

import com.yazan98.vortex.base.presenter.VortexPresenter
import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexRxView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:47 PM
 */
open class VortexRxPresenter<V : VortexRxView> : VortexPresenter.NetworkPresenter<V>() {

    override fun attachView(view: V) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(): V {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detatchView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyPresenter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addRxRequest(request: Disposable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStateHandler(): Observable<State> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun acceptNewState(newState: State) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}