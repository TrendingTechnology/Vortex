package com.yazan98.vortex.android.extras.firebase.impl

import com.yazan98.vortex.android.extras.listeners.FirestoreListener

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/21/2019
 * Time : 11:36 AM
 */

interface IVortexFirestore {

    fun createDocument(collectionName: String , documentName: String , data: Map<String , Any>)

    fun deleteDocument(collectionName: String , documentName: String)

    fun updateDocument(collectionName: String , documentName: String , data: Map<String , Any>)

    fun getAllDocumentsInCollection(collectionName: String , listener: FirestoreListener)

}
