package com.yazan98.vortex.android.extras

import com.yazan98.vortex.base.error.VortexBlockedException
import com.yazan98.vortex.base.platform.VortexBasePlatform

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:55 PM
 */

class VortexViperPlatform : VortexBasePlatform() {

    private val dependencies: ArrayList<String> by lazy { ArrayList<String>(5) }
    private val reason: ArrayList<String> by lazy { ArrayList<String>(5) }

    init {
        dependencies.add("com.yazan98.vortex.base.presenter.presenters.VortexRxPresenter")
        dependencies.add("com.yazan98.vortex.base.presenter.VortexPresenter")
        dependencies.add("com.yazan98.vortex.android.screen.VortexNetworkScreen")

        reason.add("Vortex ViewModel Platform Dependency Required ::: VortexRxPresenter")
        reason.add("Vortex ViewModel Platform Dependency Required ::: VortexPresenter")
        reason.add("Vortex ViewModel Platform Dependency Required ::: VortexNetworkScreen")

        for ((index, value) in dependencies.withIndex()) {
            if (!findClassByClassName(value)) {
                throw VortexBlockedException(reason[index])
            }
        }

    }

}

