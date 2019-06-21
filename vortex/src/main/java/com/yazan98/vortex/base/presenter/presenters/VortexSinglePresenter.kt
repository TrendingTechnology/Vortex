package com.yazan98.vortex.base.presenter.presenters

import com.yazan98.vortex.base.presenter.Presenter
import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexRxView
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:51 PM
 */

abstract class VortexSinglePresenter<V : VortexRxView, R> :
    VortexRxPresenter<V>(), Presenter.SinglePresenter<V, R , Observable<State>>
