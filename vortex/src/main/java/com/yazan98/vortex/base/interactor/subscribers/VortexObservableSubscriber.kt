package com.yazan98.vortex.base.interactor.subscribers

import io.reactivex.observers.DisposableObserver

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:59 PM
 */
abstract class VortexObservableSubscriber<R> : DisposableObserver<R>()
