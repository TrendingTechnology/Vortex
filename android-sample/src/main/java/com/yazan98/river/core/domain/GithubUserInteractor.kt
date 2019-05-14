package com.yazan98.river.core.domain

import android.annotation.SuppressLint
import android.util.Log
import com.yazan98.river.base.interactor.interactors.ObservableInteractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

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

class GithubUserInteractor : ObservableInteractor<GithubUser, Void>() {

    override fun validateParams(params: Void) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @SuppressLint("CheckResult")
    override fun executeRequest(request: Observable<GithubUser>): Disposable {
        /**
         * If You want to use any ui action you should call this method
         * provider.getObservableRequest(request, AndroidSchedulers.mainThread())
         *
         * if everything in background thread call this
         * provider.getObservableRequest(request)
         */
        return provider.getObservableRequest(request, AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    callback.onNext(response)
                }, { throwable ->
                    callback.onError(throwable)
                    throwable.printStackTrace()
                }, {
                    callback.onComplete()
                }
            )

    }

}
