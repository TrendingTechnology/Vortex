package com.yazan98.vortex.base.platform

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:49 PM
 */

open class BaseVortex {

    fun initPlatform() {
        PlatformValidator.checkFlowableDependency()
        PlatformValidator.checkMaybeDependency()
        PlatformValidator.checkObservableDependency()
        PlatformValidator.checkSingleDependency()
        PlatformValidator.checkRepositoryDependency()
    }

}
