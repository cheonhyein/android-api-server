package com.api.androidapiserver.auth.handler

import com.api.androidapiserver.auth.jwt.JwtProvider
import com.api.androidapiserver.auth.service.WebUserDetailsService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.handler
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

class LoginHandler(
//    private val webUserDetailsService: WebUserDetailsService,
//    private val jwtProvider: JwtProvider
) : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        authentication: Authentication?
    ) {
//        val userDetails = webUserDetailsService.loadUserByUsername()
//        val token = jwtProvider.createJwtToken(userDetails.username)
//        response.contentType = "application/json"
//        response.writer.write("{\"token\": \"$token\"}")
//        response.writer.flush()

        println("로그인 성공!")
    }
}
