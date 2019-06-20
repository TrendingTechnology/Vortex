package com.yazan98.vortex.base.presenter

import com.yazan98.vortex.base.platform.BaseVortex
import com.yazan98.vortex.base.view.VortexView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:38 PM
 */

abstract class VortexPresenter<V : VortexView> : Presenter<V> {

    init {
        BaseVortex().initPlatform()
    }

    abstract class LocalPresenter<V : VortexView> : VortexPresenter<V>()
    abstract class NetworkPresenter<V : VortexView> : VortexPresenter<V>(), Presenter.NetworkPresenter<V>

    //TODO : Implement this type of presenter
    abstract class HandlerPresenter<V : VortexView> : VortexPresenter<V>() , Presenter.HandlerPresenter<V>
}
