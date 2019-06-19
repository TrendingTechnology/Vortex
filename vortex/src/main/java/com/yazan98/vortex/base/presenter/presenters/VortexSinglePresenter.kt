package com.yazan98.vortex.base.presenter.presenters

import com.yazan98.vortex.base.presenter.VortexPresenter
import com.yazan98.vortex.base.view.VortexRxView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:51 PM
 */
abstract class VortexSinglePresenter<V : VortexRxView , R> : VortexPresenter.SinglePresenter<V , R>()
