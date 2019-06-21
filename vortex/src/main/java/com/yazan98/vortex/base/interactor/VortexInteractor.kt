package com.yazan98.vortex.base.interactor

import com.yazan98.vortex.base.platform.BaseVortex
import com.yazan98.vortex.base.rx.VortexThreadProvider

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:50 PM
 */

abstract class VortexInteractor<R, P> : InteractorImplementor<R, P> {

    init {
        BaseVortex().initPlatform()
    }

    abstract class SchedulerInteractor<R, P> : VortexInteractor<R, P>() {
        abstract fun getThreadProvider(): VortexThreadProvider
    }

    //TODO: Implement this when make processor
    abstract class ValidatorInteractor<R, P> : VortexInteractor<R, P>()

    abstract class ReactiveInteractor<R, P, S> : VortexInteractor<R, P>() {
        abstract var subscriber: S
    }

}
