package com.yazan98.vortex.android.extras.listeners

import com.google.firebase.auth.FirebaseUser

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 11:51 AM
 */

interface FirebaseAuthListener {

    fun onAuthCompleted(user: FirebaseUser)

    fun onAuthFailed(message: String)

}