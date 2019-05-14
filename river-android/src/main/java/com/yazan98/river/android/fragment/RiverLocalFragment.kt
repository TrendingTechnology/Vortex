package com.yazan98.river.android.fragment
import com.yazan98.river.android.base.BaseFragment
import com.yazan98.river.base.presenter.RiverPresenter
import com.yazan98.river.base.view.BaseView
import com.yazan98.river.base.view.LocalView

/**
 *    Copyright [2019] [Yazan Tarifi]
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

abstract class RiverLocalFragment<View: LocalView , Presenter : RiverPresenter<View> , Router>: BaseFragment() {


    protected abstract fun getPresenter(): Presenter
    protected abstract fun getRouter(): Router

}
