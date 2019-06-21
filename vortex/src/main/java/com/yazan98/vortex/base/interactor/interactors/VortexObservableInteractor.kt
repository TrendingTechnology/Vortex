package com.yazan98.vortex.base.interactor.interactors

import com.yazan98.vortex.base.interactor.VortexInteractor
import com.yazan98.vortex.base.interactor.subscribers.VortexObservableSubscriber
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:54 PM
 */
abstract class VortexObservableInteractor<R, P> :
    VortexInteractor.ReactiveInteractor<Observable<R>, P, VortexObservableSubscriber<R>>()
