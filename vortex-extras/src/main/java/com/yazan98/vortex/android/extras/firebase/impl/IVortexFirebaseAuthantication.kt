package com.yazan98.vortex.android.extras.firebase.impl

import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.yazan98.vortex.android.extras.listeners.FirebaseAuthListener

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 11:52 AM
 */
interface IVortexFirebaseAuthantication {

    fun signInWithEmailAndPassword(email: String, password: String)

    fun createAccountWithEmailAndPassword(email: String, password: String)

    fun loadListener(listener: FirebaseAuthListener)

    fun getAuthListener(): OnCompleteListener<AuthResult>

    fun signInWithAuthConfig(context: AppCompatActivity, requestCode: Int, methods: ArrayList<AuthUI.IdpConfig>)

    fun destroyFirebaseListener()

}

