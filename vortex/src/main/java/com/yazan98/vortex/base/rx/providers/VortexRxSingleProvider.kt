package com.yazan98.vortex.base.rx.providers

import com.yazan98.vortex.base.rx.VortexRxProvider
import com.yazan98.vortex.base.rx.VortexThreadProvider
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:12 PM
 */

abstract class VortexRxSingleProvider<R> : VortexRxProvider<R> {

    override fun getObservableRequest(request: Observable<R>): Observable<R> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(getVortexThread().getCurrentThread())
    }

    override fun getFlowableRequest(request: Flowable<R>): Flowable<R> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(getVortexThread().getCurrentThread())
    }

    override fun getSingleRequest(request: Single<R>): Single<R> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(getVortexThread().getCurrentThread())
    }

    override fun getMaybeRequest(request: Maybe<R>): Maybe<R> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(getVortexThread().getCurrentThread())
    }

    protected abstract fun getVortexThread(): VortexThreadProvider

}
