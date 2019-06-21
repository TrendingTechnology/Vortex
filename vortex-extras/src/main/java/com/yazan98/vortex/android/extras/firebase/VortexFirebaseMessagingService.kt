package com.yazan98.vortex.android.extras.firebase

import androidx.annotation.CallSuper
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.yazan98.vortex.android.extras.models.VortexNotification

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:02 PM
 */
abstract class VortexFirebaseMessagingService : FirebaseMessagingService() {

    @CallSuper
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
        //TODO: Implement this when make notifications
    }

    protected abstract fun getNotification(): VortexNotification

}
