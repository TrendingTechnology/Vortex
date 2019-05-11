
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
package com.yazan98.river.data.room

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created By : Yazan Tarifi
 * Date : 5/4/2019
 * Time : 10:33 PM
 */

@Dao
interface RiverDao<E, ID> {

    @Insert
    fun insertData(body: E): Single<Entity>

    @RawQuery
    fun getEntityById(query: String): Single<Entity>

    @RawQuery
    fun getAllEntities(query: String): Flowable<List<Entity>>

    @Update
    fun updateEntity(body: Entity): Completable

    @Delete
    fun deleteEntityById(id: ID): Completable

    @Delete
    fun deleteAllEntites(): Completable

}
