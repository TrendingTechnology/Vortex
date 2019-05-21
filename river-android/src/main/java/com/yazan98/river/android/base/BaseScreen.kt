package com.yazan98.river.android.base
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.yazan98.river.base.scopes.StartupScope
import com.yazan98.river.base.view.BaseView

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

abstract class BaseScreen : AppCompatActivity(), LifecycleOwner{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initScreen()
    }

    protected fun getArgs(): Bundle {
        return intent!!.extras!!
    }

    @StartupScope
    protected abstract fun initScreen()

    protected abstract fun getLayoutRes(): Int

}
