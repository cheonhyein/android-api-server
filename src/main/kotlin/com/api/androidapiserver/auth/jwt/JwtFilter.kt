package com.api.androidapiserver.auth.jwt

import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import io.micrometer.common.util.StringUtils
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.jwt
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

class JwtFilter(private val inMemoryTokenStore: InMemoryTokenStore, private val jwtProvider: JwtProvider) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        var token = jwtProvider.getToken(request)

        if (token != null && StringUtils.isNotEmpty(token) && token.indexOf("Bearer") > -1) {
            val authentication = jwtProvider.getAuthentication(token.replace("Bearer ", ""))
            SecurityContextHolder.getContext().authentication = authentication
//            if(jwtProvider.validateJwtToken(token) && inMemoryTokenStore.validateToken(token)) {
//                val authentication = jwtProvider.getAuthentication(token)
//                SecurityContextHolder.getContext().authentication = authentication
//            }
        }

        filterChain.doFilter(request, response)
    }



}
