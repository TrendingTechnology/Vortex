package com.yazan98.vortex.base.interactor

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:50 PM
 */

abstract class VortexInteractor<R, P> : InteractorImplementor<R , P> {
    abstract class ReactiveInteractor<R, P> : VortexInteractor<R, P>()
    abstract class SchedularInteractor<R, P> : VortexInteractor<R, P>()
    abstract class ValidatorInteractor<R, P> : VortexInteractor<R, P>()
}
