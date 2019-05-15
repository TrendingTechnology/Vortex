package com.yazan98.river.base.rx

import io.reactivex.*
import io.reactivex.schedulers.Schedulers


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

class RxProvider<Request> {

    fun getObservableRequest(request: Observable<Request>): Observable<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getFlowableRequest(request: Flowable<Request>): Flowable<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getSingleRequest(request: Single<Request>): Single<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getMaybeRequest(request: Maybe<Request>): Maybe<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getObservableListRequest(request: Observable<List<Request>>): Observable<List<Request>> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getFlowableListRequest(request: Flowable<List<Request>>): Flowable<List<Request>> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getSingleListRequest(request: Single<List<Request>>): Single<List<Request>> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getMaybeListRequest(request: Maybe<List<Request>>): Maybe<List<Request>> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
    }

    fun getObservableRequest(request: Observable<Request>, schedulers: Scheduler): Observable<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(schedulers)
    }

    fun getFlowableRequest(request: Flowable<Request> , schedulers: Scheduler): Flowable<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(schedulers)
    }

    fun getSingleRequest(request: Single<Request> , schedulers: Scheduler): Single<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(schedulers)
    }

    fun getMaybeRequest(request: Maybe<Request> , schedulers: Scheduler): Maybe<Request> {
        return request
            .subscribeOn(Schedulers.io())
            .observeOn(schedulers)
    }

}
