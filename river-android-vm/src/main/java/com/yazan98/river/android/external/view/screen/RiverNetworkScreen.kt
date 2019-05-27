package com.yazan98.river.android.external.view.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import com.yazan98.river.android.external.view.base.BaseScreen
import com.yazan98.river.android.external.vm.RiverNetworkViewModel
import com.yazan98.river.base.view.NetworkView
import com.yazan98.river.base.view.RiverVmView

/**
 *    Copyright 2019 Yazan Tarifi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/**
 * Created By : Yazan Tarifi
 * Date : 5/26/2019
 * Time : 10:10 PM
 */
abstract class RiverNetworkScreen<View: RiverVmView , VM : RiverNetworkViewModel<View>> : BaseScreen() , RiverVmView {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModelStatus()
    }

    private fun registerViewModelStatus() {
        getViewModel().getViewModelStatus().observe(this , Observer {
            onStateChanged(it)
        })
    }

    protected abstract fun getViewModel(): VM

}
