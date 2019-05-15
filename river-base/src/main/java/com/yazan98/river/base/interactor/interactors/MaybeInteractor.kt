package com.yazan98.river.base.interactor.interactors

import com.yazan98.river.base.interactor.RiverInteractor
import com.yazan98.river.base.interactor.subscribers.MaybeSubscriber
import com.yazan98.river.base.rx.RxProvider
import io.reactivex.Maybe
import io.reactivex.Scheduler
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

/**
 * Created By : Yazan Tarifi
 * Date : 5/11/2019
 * Time : 12:26 AM
 */

abstract class MaybeInteractor<Request, in Params> : RiverInteractor<Maybe<Request>, Params>() {

    lateinit var callback: MaybeSubscriber<Request>
    val provider: RxProvider<Request> = RxProvider()

    protected fun getDefaultSubscriber(request: Maybe<Request>): Disposable {
        return provider.getMaybeRequest(request)
            .subscribe(
                { response ->
                    callback.onSuccess(response)
                }, { throwable ->
                    callback.onError(throwable)
                    throwable.printStackTrace()
                }, {
                    callback.onComplete()
                }
            )
    }

    protected fun getDefaultSchedulerSubscriber(request: Maybe<Request>, thread: Scheduler): Disposable {
        return provider.getMaybeRequest(request, thread)
            .subscribe(
                { response ->
                    callback.onSuccess(response)
                }, { throwable ->
                    callback.onError(throwable)
                    throwable.printStackTrace()
                }, {
                    callback.onComplete()
                }
            )
    }

}
