package com.yazan98.river.base.interactor.interactors

import com.yazan98.river.base.interactor.RiverInteractor
import com.yazan98.river.base.interactor.subscribers.ObservableSubscriber
import com.yazan98.river.base.rx.RxProvider
import io.reactivex.Observable
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
 * Time : 12:23 AM
 */

abstract class ObservableInteractor<Request, in Params>(thread: Scheduler) : RiverInteractor<Observable<Request>, Params>() {

    val provider: RxProvider<Request> = RxProvider()
    lateinit var callback: ObservableSubscriber<Request>

    protected fun getDefaultSubscriber(request: Observable<Request>): Disposable {
        return provider.getObservableRequest(request)
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

    protected fun getDefaultSchedulerSubscriber(request: Observable<Request>, thread: Scheduler): Disposable {
        return provider.getObservableRequest(request, thread)
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
