package com.yazan98.vortex.base.presenter.presenters

import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexViewException
import com.yazan98.vortex.base.presenter.VortexPresenter
import com.yazan98.vortex.base.view.VortexView

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:47 PM
 */

open class VortexLocalPresenter<V : VortexView> : VortexPresenter.LocalPresenter<V>() {

    private var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun getView(): V {
        if (view != null)
            return this.view!!
        else
            throw VortexViewException(VortexConsts.EMPTY_VIEW)
    }

    override fun detatchView() {
        this.view = null
    }

    override fun destroyPresenter() {
        this.detatchView()
    }

}
