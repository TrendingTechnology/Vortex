package com.yazan98.vortex.base.platform

import com.yazan98.vortex.base.VortexConsts
import com.yazan98.vortex.base.error.VortexBlockedException

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:00 PM
 */
object PlatformValidator {

    fun checkObservableDependency() {
        if (!VortexPlatform.DEPENDENCY_OBSERVABLE)
            throw VortexBlockedException(VortexConsts.OBSERVABLE_NOT_FOUND)
    }

    fun checkFlowableDependency() {
        if (!VortexPlatform.DEPENDENCY_FLOWABLE)
            throw VortexBlockedException(VortexConsts.FLOWABLE_NOT_FOUND)
    }

    fun checkMaybeDependency() {
        if (!VortexPlatform.DEPENDENCY_MAYBE)
            throw VortexBlockedException(VortexConsts.MAYBE_NOT_FOUND)
    }

    fun checkSingleDependency() {
        if (!VortexPlatform.DEPENDENCY_SINGLE)
            throw VortexBlockedException(VortexConsts.SINGLE_NOT_FOUND)
    }

    fun checkRepositoryDependency() {
        if (!VortexPlatform.DEPENDENCY_REPOSITORY)
            throw VortexBlockedException(VortexConsts.REPOSITORY_NOT_FOUND)
    }
}