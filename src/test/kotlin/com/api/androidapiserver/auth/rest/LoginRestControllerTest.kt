package com.api.androidapiserver.auth.rest

import com.api.androidapiserver.api.dto.UserDto
import com.api.androidapiserver.api.repository.UserRepository
import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import com.api.androidapiserver.auth.jwt.JwtProvider
import com.api.androidapiserver.auth.service.WebUserDetailsService
import org.apache.catalina.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.rest
</pre> *
 *
 * @author
 * @since 1/5/24
 */

class LoginRestControllerTest {

    private lateinit var jwtProvider: JwtProvider
    private lateinit var tokenStore: InMemoryTokenStore
    private lateinit var loginRestController: LoginRestController
    private lateinit var webUserDetailsService: WebUserDetailsService

    @BeforeEach
    fun setUp() {
        tokenStore = InMemoryTokenStore()
        jwtProvider = JwtProvider(tokenStore)
        webUserDetailsService = WebUserDetailsService()
        loginRestController = LoginRestController(webUserDetailsService, jwtProvider)
    }

    @Test
    fun login() {
        var userDto = UserDto("hyein", "1")
        var result = loginRestController.login(userDto)
        println(result)

    }
}
