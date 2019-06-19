package com.yazan98.vortex.base.interactor

import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:54 PM
 */

interface InteractorImplementor<R , P> {

    fun validate(content: P)

    fun execute(request: R): Disposable

}
