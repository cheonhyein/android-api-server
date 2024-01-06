package com.api.androidapiserver.auth.jwt

import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.jwt
</pre> *
 *
 * @author
 * @since 1/5/24
 */

class JwtProviderTest() {

    private lateinit var jwtProvider: JwtProvider
    private lateinit var tokenStore: InMemoryTokenStore


    @BeforeEach
    fun setUp() {
        tokenStore = InMemoryTokenStore()
        jwtProvider = JwtProvider(tokenStore)
        print("setUp")
    }

    @Test
    fun getToken() {
//        val jwt = jwtProvider.createJwtToken("hyein")
//        println("jwt : $jwt")
    }

    @Test
    fun validateJwtToken() {
    }

    @Test
    fun getAuthentication() {
    }

    @Test
    fun createJwtToken() {
    }

    @Test
    fun getTokenStore() {
    }
}
