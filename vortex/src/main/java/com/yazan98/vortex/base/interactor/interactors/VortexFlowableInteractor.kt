package com.yazan98.vortex.base.interactor.interactors

import com.yazan98.vortex.base.interactor.VortexInteractor
import io.reactivex.Flowable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:56 PM
 */
abstract class VortexFlowableInteractor<R, P> : VortexInteractor.ReactiveInteractor<Flowable<R>, P>()
