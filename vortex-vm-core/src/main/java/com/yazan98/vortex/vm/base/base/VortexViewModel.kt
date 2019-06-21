package com.yazan98.vortex.vm.base.base

import androidx.lifecycle.ViewModel
import com.yazan98.vortex.base.presenter.Presenter
import com.yazan98.vortex.base.view.VortexView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:46 PM
 */

sealed class VortexViewModel<V : VortexView> : ViewModel(), Presenter<V> {
    abstract class LocalViewModel<V : VortexView> : VortexViewModel<V>()
    abstract class NetworkViewModel<V : VortexView, T> : VortexViewModel<V>(), Presenter.NetworkPresenter<V, T>
    abstract class SchedularViewModel<V : VortexView, T> : NetworkViewModel<V, T>()
    abstract class SingleViewModel<V : VortexView, R, T> : VortexViewModel<V>(), Presenter.SinglePresenter<V, R, T>
}
