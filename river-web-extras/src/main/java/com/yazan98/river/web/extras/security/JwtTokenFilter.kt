package com.yazan98.river.web.extras.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
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
 * Time : 4:17 PM
 */

class JwtTokenFilter(private var jwtTokenProvider: JwtTokenProvider?) : GenericFilterBean() {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, filterChain: FilterChain) {

        val token = jwtTokenProvider!!.resolveToken(req as HttpServletRequest)
        if (token != null && jwtTokenProvider!!.validateToken(token)) {
            val auth = jwtTokenProvider!!.getAuthentication(token)

            SecurityContextHolder.getContext().authentication = auth
        }
        filterChain.doFilter(req, res)
    }

    fun setJwtTokenProvider(jwtTokenProvider: JwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider
    }
}
