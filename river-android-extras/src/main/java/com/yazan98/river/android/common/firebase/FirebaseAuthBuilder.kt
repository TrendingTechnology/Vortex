
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
package com.yazan98.river.android.common.firebase

import androidx.fragment.app.FragmentActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth


/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 18:38
 */

object FirebaseAuthBuilder {

    private lateinit var listener: FirebaseAuthCallback

    fun signInWithEmailAndPassword(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(getAuthListener())
    }

    fun createAccountWithEmailAndPassword(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(getAuthListener())
    }

    fun loadListener(listener: FirebaseAuthCallback) {
        this.listener = listener
    }

    private fun getAuthListener(): OnCompleteListener<AuthResult> {
        return OnCompleteListener<AuthResult> {
            if (!it.isSuccessful) {
                listener.onAuthFailed(it.exception!!.message!!)
            } else {
                listener.onAuthCompleted(it.result!!.user)
            }
        }
    }

    /**
    new AuthUI.IdpConfig.GoogleBuilder().build(),
    new AuthUI.IdpConfig.FacebookBuilder().build(),
    new AuthUI.IdpConfig.TwitterBuilder().build(),
    new AuthUI.IdpConfig.GitHubBuilder().build(),
    new AuthUI.IdpConfig.EmailBuilder().build(),
    new AuthUI.IdpConfig.PhoneBuilder().build(),
    new AuthUI.IdpConfig.AnonymousBuilder().build()
     */
    fun signInWithAuthConfig(context: FragmentActivity, requestCode: Int, methods: ArrayList<AuthUI.IdpConfig>) {
        context.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(
                    methods
                )
                .build(),
            requestCode
        )
    }


}
