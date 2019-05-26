package com.yazan98.river.android.external.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.yazan98.river.android.base.BaseFragment
import com.yazan98.river.android.external.vm.base.RiverViewModel
import com.yazan98.river.base.scopes.StartupScope
import com.yazan98.river.base.view.NetworkView

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
 * Time : 10:17 PM
 */
abstract class RiverOneWayFragment<View: NetworkView , Repo , VM :
    RiverViewModel.RiverOneWayNetworkViewModel<View , Repo>> : BaseFragment() , NetworkView {

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlePresenterStatus()
    }

    @StartupScope
    @SuppressLint("CheckResult")
    private fun handlePresenterStatus() {
        getViewModel().getPresenterStatus().subscribe {
            getViewModel().getView().acceptPresenterStatus(it)
        }
    }

    protected abstract fun getViewModel(): VM

}
