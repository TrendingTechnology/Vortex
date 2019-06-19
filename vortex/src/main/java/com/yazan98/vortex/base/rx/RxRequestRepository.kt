package com.yazan98.vortex.base.rx

import com.yazan98.vortex.base.VortexConsts
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:21 PM
 */

class RxRequestRepository {

    private val repo: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun addRequest(request: Disposable) {
        this.repo.add(request)
    }

    fun clearAllRequests() {
        when (repo.size()) {
            0 -> println(VortexConsts.EMPTY_REQUEST_REPO)
            else -> this.repo.clear()
        }
    }

}