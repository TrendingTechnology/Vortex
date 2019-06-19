package com.yazan98.vortex.base.rx

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:11 PM
 */
interface VortexRxProvider<R> {

    fun getObservableRequest(request: Observable<R>): Observable<R>

    fun getFlowableRequest(request: Flowable<R>): Flowable<R>

    fun getSingleRequest(request: Single<R>): Single<R>

    fun getMaybeRequest(request: Maybe<R>): Maybe<R>

}
