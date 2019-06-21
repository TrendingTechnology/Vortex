package com.yazan98.vortex.android.external.fragment

import com.yazan98.vortex.android.external.base.VortexBaseFragment
import com.yazan98.vortex.android.extras.ui.ViewPagerAdapter

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 5:29 PM
 */

abstract class VortexPagerFragment : VortexBaseFragment() {

    protected val pager: ViewPagerAdapter by lazy {
        ViewPagerAdapter(activity!!.supportFragmentManager)
    }

}
