package com.yazan98.vortex.data

import retrofit2.Retrofit

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:42 PM
 */

abstract class VortexRepository<Api> {

    open lateinit var retrofit: Retrofit

    protected fun getServiceProvider(): Retrofit {
        return if (::retrofit.isInitialized) {
            retrofit
        } else {
            RetrofitProvider.getDefaultRetrofit(getBaseUrl())
        }
    }

    protected abstract fun getBaseUrl(): String
    protected abstract fun getService(): Api

}
