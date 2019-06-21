package com.yazan98.vortex.android.screen

import com.yazan98.vortex.android.base.VortexBaseScreen
import com.yazan98.vortex.android.extras.ui.ViewPagerAdapter

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 4:41 PM
 */

abstract class VortexPagerScreen : VortexBaseScreen() {

    protected val pager: ViewPagerAdapter by lazy {
        ViewPagerAdapter(supportFragmentManager)
    }

}
