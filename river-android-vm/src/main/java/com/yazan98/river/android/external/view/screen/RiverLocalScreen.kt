package com.yazan98.river.android.external.view.screen

import com.yazan98.river.android.external.view.base.BaseScreen
import com.yazan98.river.android.external.vm.RiverLocalViewModel
import com.yazan98.river.base.view.BaseView
import com.yazan98.river.base.view.LocalView

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
 * Time : 10:05 PM
 */

abstract class RiverLocalScreen<View: LocalView , VM: RiverLocalViewModel<View>> : BaseScreen() , BaseView {

    protected abstract fun getViewModel(): VM

}
