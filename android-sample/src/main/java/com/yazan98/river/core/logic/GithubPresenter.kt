package com.yazan98.river.core.logic

import android.util.Log
import com.yazan98.river.base.interactor.subscribers.ObservableSubscriber
import com.yazan98.river.base.state.State
import com.yazan98.river.base.presenter.RiverRxPresenter
import com.yazan98.river.core.data.GithubRepo
import com.yazan98.river.core.domain.GithubUser
import com.yazan98.river.core.domain.GithubUserInteractor

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

/**
 * Created By : Yazan Tarifi
 * Date : 5/14/2019
 * Time : 11:58 PM
 */

class GithubPresenter : RiverRxPresenter<GithubView>() {

    private val interactor: GithubUserInteractor = GithubUserInteractor()
    private val repo: GithubRepo = GithubRepo()

    init {
        interactor.callback = object : ObservableSubscriber<GithubUser>() {
            override fun onComplete() {
                changePresenterStatus(State.FINISHED)
            }

            override fun onNext(t: GithubUser) {
                getView().onGithubSuccess(t)
            }

            override fun onError(e: Throwable) {
                getView().onError(e)
            }

        }
    }

    fun getUser() {
        Log.e("Github Screen " , "Get User Presenter")
        changePresenterStatus(State.LOADING)
        interactor.executeRequest(repo.getUser())
    }
}