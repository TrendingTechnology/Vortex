package com.yazan98.river.android.external.vm.base

import androidx.lifecycle.ViewModel
import com.yazan98.river.base.presenter.base.Presenter
import com.yazan98.river.base.presenter.base.RiverPresenterImpl
import com.yazan98.river.base.presenter.base.RiverRxOneWayPresenterImpl
import com.yazan98.river.base.presenter.base.RiverRxPresenterImpl
import com.yazan98.river.base.view.LocalView
import com.yazan98.river.base.view.NetworkView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

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
 * Time : 9:47 PM
 */

sealed class RiverViewModel : ViewModel(), Presenter {

    abstract class RiverLocalViewModelImpl<View : LocalView> : RiverViewModel(), RiverPresenterImpl<View>
    abstract class RiverNetworkViewModelImpl<View : NetworkView> : RiverViewModel(), RiverRxPresenterImpl<View>
    abstract class RiverOneWayNetworkViewModel<View : NetworkView, Repo> : RiverViewModel(),
        RiverRxOneWayPresenterImpl<View, Repo>

    protected fun getMainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}
