package com.yazan98.vortex.base.presenter

import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:40 PM
 */
interface Presenter<V : VortexView> {

    fun attachView(view: V)

    fun getView(): V

    fun detatchView()

    fun destroyPresenter()

    interface NetworkPresenter<V : VortexView> : Presenter<V> {

        fun addRxRequest(request: Disposable)

        fun getStateHandler(): Observable<State>

        fun acceptNewState(newState: State)

    }

    interface SinglePresenter<V : VortexView , R> : NetworkPresenter<V> {

        fun getRepository(): R

    }

}
