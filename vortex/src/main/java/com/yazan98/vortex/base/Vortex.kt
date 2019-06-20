package com.yazan98.vortex.base

import com.yazan98.vortex.base.platform.BaseVortex

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:21 PM
 */

class Vortex {

    fun initPlatform(): Vortex {
        BaseVortex().initPlatform()
        return this
    }

}
