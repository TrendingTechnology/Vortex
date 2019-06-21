package com.yazan98.vortex.android.extras.listeners

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 11:48 AM
 */

interface FirestoreListener {

    fun onSuccess(data: List<String>)

    fun onError(message: String)

}
