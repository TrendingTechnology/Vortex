package com.yazan98.river.web.extras.database

import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.yazan98.river.web.extras.database.info.MongoDatabaseInfo
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.core.mapping.MongoMappingContext



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

/**
 * Created By : Yazan Tarifi
 * Date : 5/17/2019
 * Time : 3:55 PM
 */

abstract class RiverMongoConfiguration : AbstractMongoConfiguration(), RiverDatabaseConfigure<MongoDatabaseInfo> {

    override fun getDatabaseType(): String {
        return SupportedDatabases.MONGO.name
    }

    @Throws(ClassNotFoundException::class)
    override fun mongoMappingContext(): MongoMappingContext {
        return super.mongoMappingContext()
    }

    @Bean
    @Throws(Exception::class)
    fun mongo(): Mongo {
        return MongoClient("${getDatabaseInfo().host}:${getDatabaseInfo().port}")
    }

    override fun getDatabaseName(): String {
        return getDatabaseInfo().name
    }

    override fun mongoClient(): MongoClient {
        return MongoClient()
    }

}
