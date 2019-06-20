package com.yazan98.vortex.data

import com.yazan98.vortex.base.rx.VortexThreadProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:57 PM
 */

class VortexAndroidThreadProvider : VortexThreadProvider {

    override fun getCurrentThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}
