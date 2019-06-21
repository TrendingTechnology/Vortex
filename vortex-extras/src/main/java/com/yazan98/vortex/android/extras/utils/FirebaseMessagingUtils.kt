package com.yazan98.vortex.android.extras.utils

import com.google.firebase.messaging.FirebaseMessaging

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 12:07 PM
 */

object FirebaseMessagingUtils {

    fun enableRealtimeCalles() {
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }

    fun subsctibeTopic(name: String) {
        FirebaseMessaging.getInstance().subscribeToTopic(name)
    }

    fun unSubscribeTopic(name: String) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(name)
    }

    fun subscribeTopics(keys: ArrayList<String>) {
        for (key in keys) {
            subsctibeTopic(key)
        }
    }

    fun unSubscribeTopics(keys: ArrayList<String>) {
        for (key in keys) {
            unSubscribeTopic(key)
        }
    }

}
