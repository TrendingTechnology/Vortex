package com.yazan98.vortex.base.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:31 PM
 */

object VortexExternalThread : VortexThreadProvider {

    override fun getCurrentThread(): Scheduler {
        return Schedulers.newThread()
    }

}

