
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
package com.yazan98.river.android.common.firebase

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 11:54 AM
 */
object FirebaseDatabaseManager {

    fun offlineQuery(path: String, callback: DatabaseQueryCallback) {
        val scoresRef = FirebaseDatabase.getInstance().getReference(path)
        scoresRef.orderByValue().limitToLast(4).addChildEventListener(object : ChildEventListener {

            override fun onCancelled(p0: DatabaseError) {
                callback.onError(p0)
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                callback.onChildChanged(p0, p1!!)
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChild: String?) {
                callback.onChildAdded(snapshot, previousChild!!)
            }

        })
    }
}