
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

package com.yazan98.river.android.common

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.f2prateek.rx.preferences2.Preference
import com.f2prateek.rx.preferences2.RxSharedPreferences

/**
 * Created By : Yazan Tarifi
 * Date : 02/05/2019
 * Time : 22:58
 */
object AccountPrefs {

    private lateinit var tokenItem: Preference<String>
    private lateinit var userId: Preference<Long>
    private lateinit var loginStatus: Preference<Boolean>
    private lateinit var preferences: SharedPreferences
    private lateinit var rxPreferences: RxSharedPreferences

    fun initializeCommonPrefs(context: Context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
        rxPreferences = RxSharedPreferences.create(preferences)
    }

    fun saveToken(token: String) {
        tokenItem = rxPreferences.getString("Token")
        tokenItem.set(token)
    }

    fun getToken(): String {
        tokenItem = rxPreferences.getString("Token")
        return tokenItem.get()
    }

    fun saveUserId(userId: Long) {
        this.userId = rxPreferences.getLong("UserId")
        this.userId.set(userId)
    }

    fun getUserId(): Long {
        this.userId = rxPreferences.getLong("UserId")
        return this.userId.get()
    }

    fun saveLoginStatus(newStatus: Boolean) {
        loginStatus = rxPreferences.getBoolean("LoginStatus")
        loginStatus.set(newStatus)
    }

    fun getLoginStatus(): Boolean {
        loginStatus = rxPreferences.getBoolean("LoginStatus")
        return loginStatus.get()
    }

}
