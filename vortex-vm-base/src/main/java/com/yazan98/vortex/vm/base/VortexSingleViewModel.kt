package com.yazan98.vortex.vm.base

import androidx.lifecycle.MutableLiveData
import com.yazan98.vortex.base.state.State
import com.yazan98.vortex.base.view.VortexRxView
import com.yazan98.vortex.vm.base.base.VortexViewModel

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:53 PM
 */

abstract class VortexSingleViewModel<V: VortexRxView , R> :
    VortexViewModel.SingleViewModel<V , R , MutableLiveData<State>>()
