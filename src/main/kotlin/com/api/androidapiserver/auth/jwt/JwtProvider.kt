package com.api.androidapiserver.auth.jwt

import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.micrometer.common.util.StringUtils
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.lang.RuntimeException
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
@Configuration
class JwtProvider(val tokenStore: InMemoryTokenStore) {

    private val SECRET_KEY = "hyeinjgfjgfin"
    private val EXPIRATION_TIME = 60
    fun getToken(request : HttpServletRequest) : String {
        val bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION)
        return if (StringUtils.isEmpty(bearerToken) && bearerToken.startsWith("Bearer")) bearerToken.replace("Bearer ", "") else bearerToken
    }

    fun validateJwtToken(token : String) : Boolean {
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
            return true
        }catch (e : Exception) {
            return false
        }
    }

    fun getAuthentication(token : String) : Authentication {
        try {
            val username = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .body.subject
            return UsernamePasswordAuthenticationToken(username, null, null)
        }catch (e : Exception) {
            throw RuntimeException("Authentication Error!")
        }
    }

    fun createJwtToken(username : String) : String {
        val token = Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact()
        tokenStore.storeToken(token, username)
        return token
    }
}
