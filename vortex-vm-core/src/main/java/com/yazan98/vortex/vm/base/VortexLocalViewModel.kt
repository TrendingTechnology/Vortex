package com.yazan98.vortex.vm.base

import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexBlockedException
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.base.VortexViewModel
import java.lang.ref.WeakReference

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:51 PM
 */

open class VortexLocalViewModel<V : VortexRxView> : VortexViewModel.LocalViewModel<V>() {

    private var view: WeakReference<V>? = null

    override fun attachView(view: V) {
        this.view = WeakReference(view)
    }

    @Throws(VortexBlockedException::class)
    override fun getView(): V {
        if (this.view!!.get() != null) {
            return view!!.get()!!
        } else {
            throw VortexBlockedException(
                VortexConsts.EMPTY_VIEW_VM
            )
        }
    }

    override fun detatchView() {
        this.view!!.clear()
        this.view = null
    }

    override fun destroyPresenter() {
        detatchView()
    }

}
