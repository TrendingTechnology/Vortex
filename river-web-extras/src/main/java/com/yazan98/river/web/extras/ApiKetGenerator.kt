package com.yazan98.river.web.extras

import java.security.NoSuchAlgorithmException
import javax.crypto.KeyGenerator
import javax.xml.bind.DatatypeConverter



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
 * Time : 4:15 PM
 */

object ApiKetGenerator {

    /**
     * keyLen 256
     * @throws NoSuchAlgorithmException
     */
    @Throws(NoSuchAlgorithmException::class)
    fun generate(keyLen: Int): String {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(keyLen)
        val secretKey = keyGen.generateKey()
        val encoded = secretKey.encoded
        return DatatypeConverter.printHexBinary(encoded).toLowerCase()
    }

    /**
     * keyLen 256
     * @throws NoSuchAlgorithmException
     */
    @Throws(NoSuchAlgorithmException::class)
    fun generate(): String {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(256)
        val secretKey = keyGen.generateKey()
        val encoded = secretKey.encoded
        return DatatypeConverter.printHexBinary(encoded).toLowerCase()
    }

}
