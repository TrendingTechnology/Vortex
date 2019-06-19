package com.yazan98.vortex.base.interactor.interactors

import com.yazan98.vortex.base.interactor.VortexInteractor
import io.reactivex.Maybe

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:57 PM
 */
abstract class VortexMaybeInteractor<R, P> : VortexInteractor.ReactiveInteractor<Maybe<R>, P>()
