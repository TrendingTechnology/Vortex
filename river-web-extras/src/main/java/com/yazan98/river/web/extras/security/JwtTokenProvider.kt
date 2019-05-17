package com.yazan98.river.web.extras.security


import com.yazan98.river.base.error.UnauthrizedError
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


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
 * Time : 4:18 PM
 */

abstract class JwtTokenProvider {

    private var claims: Claims? = null
    private var secretKey: String? = null
    private var validityInMilliseconds: Long = 0
    private var username: String? = null

    @PostConstruct
    protected fun init() {
        this.secretKey = getTokenDetails().secreteKey
        this.validityInMilliseconds = getTokenDetails().validityInMilliseconds
    }

    fun addClaim(key: String, value: String) {
        if (claims == null) {
            if (username == null) {
                claims = Jwts.claims().setSubject("Empty UserName")
            } else {
                claims = Jwts.claims().setSubject(getUsername())
            }
        }

        claims!![key] = value

    }

    fun createToken(username: String): String {
        claims = Jwts.claims().setSubject(username)

        val now = Date()
        val validity = Date(now.getTime() + validityInMilliseconds)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()
    }

    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails = this.getUserDetails().loadUserByUsername(getUsername(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getUsername(token: String): String {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }

    fun validateToken(token: String): Boolean {
        try {
            val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            return !claims.body.expiration.before(Date())
        } catch (e: JwtException) {
            throw UnauthrizedError(getUnauthrizedMessage())
        } catch (e: IllegalArgumentException) {
            throw UnauthrizedError(getUnauthrizedMessage())
        }

    }

    fun setUsername(username: String) {
        this.username = username
    }

    private fun getUsername(): String {
        return username!!
    }

    protected abstract fun getTokenDetails(): TokenConfigureDetails
    protected abstract fun getUnauthrizedMessage(): String
    protected abstract fun getUserDetails(): UserDetailsService

}
