package com.yazan98.vortex.android.extras

import com.yazan98.vortex.base.error.VortexBlockedException
import com.yazan98.vortex.base.platform.VortexBasePlatform

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 1:43 PM
 */

class VortexViewModelPlatform : VortexBasePlatform() {

    private val dependencies: ArrayList<String> by lazy { ArrayList<String>(5) }
    private val reason: ArrayList<String> by lazy { ArrayList<String>(5) }

    init {
        dependencies.add("androidx.lifecycle.LifecycleOwner")
        dependencies.add("com.yazan98.vortex.base.view.VortexRxView")
        dependencies.add("androidx.fragment.app.Fragment")
        dependencies.add("com.yazan98.vortex.vm.base.VortexNetworkViewModel")
        dependencies.add("androidx.lifecycle.ViewModel")

        reason.add("Vortex ViewModel Platform Dependency Required ::: LifecycleOwner")
        reason.add("Vortex ViewModel Platform Dependency Required ::: VortexRxView")
        reason.add("Vortex ViewModel Platform Dependency Required ::: Fragment")
        reason.add("Vortex ViewModel Platform Dependency Required ::: VortexNetworkViewModel")
        reason.add("Vortex ViewModel Platform Dependency Required ::: ViewModel")

        for ((index, value) in dependencies.withIndex()) {
            if (!findClassByClassName(value)) {
                throw VortexBlockedException(reason[index])
            }
        }

    }

}
