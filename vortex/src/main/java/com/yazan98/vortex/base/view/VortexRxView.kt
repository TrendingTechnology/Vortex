package com.yazan98.vortex.base.view

import com.yazan98.vortex.base.state.State

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:48 PM
 */

interface VortexRxView : VortexView {

    fun initScreen()

    fun onNewState(newState: State)

}
