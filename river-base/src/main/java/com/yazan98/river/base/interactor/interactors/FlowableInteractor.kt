package com.yazan98.river.base.interactor.interactors

import com.yazan98.river.base.interactor.RiverInteractor
import com.yazan98.river.base.rx.RxProvider
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
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
 * Time : 12:24 AM
 */

abstract class FlowableInteractor<Request, in Params>(thread: Scheduler) : RiverInteractor<Flowable<Request>, Params>() {

    val provider: RxProvider<Request> = RxProvider()
    lateinit var callback: FlowableSubscriber<Request>

    protected fun getDefaultSubscriber(request: Flowable<Request>): Disposable {
        return provider.getFlowableRequest(request)
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

    protected fun getDefaultSchedulerSubscriber(request: Flowable<Request>, thread: Scheduler): Disposable {
        return provider.getFlowableRequest(request, thread)
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
