import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.yazan98.river.base.router.Router
import com.yazan98.river.base.router.RouterAction

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

abstract class RiverAndroidRouter<Action: RouterAction> : Router {

    protected fun startScreen(context: FragmentActivity, targetScreen: Class<*>, isFinishEnabled: Boolean) {
        context.startActivity(Intent(context, targetScreen))
        if (isFinishEnabled) {
            context.finish()
        }
    }

    protected fun startScreenWithAutomaticFinish(context: FragmentActivity, targetScreen: Class<*>) {
        context.startActivity(Intent(context, targetScreen))
        context.finish()
    }

    fun addFragment(context: FragmentActivity, frameLayout: Int, fragment: Fragment) {
        context.supportFragmentManager
            .beginTransaction()
            .add(frameLayout, fragment)
            .commit()
    }

    fun replaceFragment(context: FragmentActivity, frameLayout: Int, fragment: Fragment) {
        context.supportFragmentManager
            .beginTransaction()
            .replace(frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun navigateFragmentByAction(view: Fragment, actionId: Int) {
        view.findNavController()
            .navigate(actionId)
    }

    fun navigateFragmentByActionWithBundle(view: Fragment, actionId: Int, data: Bundle) {
        view.findNavController()
            .navigate(actionId, data)
    }

    protected abstract fun acceptRouterAction(action: Action)

}
