package com.api.androidapiserver.auth.jwt

import com.api.androidapiserver.api.dto.UserDetailDto
import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import com.api.androidapiserver.auth.user.AccountUserDetails
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.micrometer.common.util.StringUtils
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.io.IOException
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
    private val EXPIRATION_TIME = 1000L * 60 * 60 // 1시간
    fun getToken(request : HttpServletRequest) : String? {
        val bearerToken : String? = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (bearerToken != null) {
            return if (StringUtils.isEmpty(bearerToken) && bearerToken.startsWith("Bearer")) bearerToken.replace("Bearer ", "") else bearerToken
        }
        return null
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
//            var claims : Map<String, String>? = null
//
//            try {
//                claims =
//            }catch (e : IOException) {
//                println(e.printStackTrace())
//            }


            val principal = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .body
            println("principal : $principal")
            val rolesList = principal["roles"] as? List<String> ?: emptyList()
            val authority : Collection<out GrantedAuthority> = rolesList.map { SimpleGrantedAuthority(it) }
            return UsernamePasswordAuthenticationToken(principal, null, authority)
        }catch (e : Exception) {
            println(e.printStackTrace())
            throw RuntimeException("Authentication Error!")
        }
    }

    fun createJwtToken(user : AccountUserDetails) : String {

        val claims = Jwts.claims()
        claims["userId"] = user.username
        claims["userName"] = user.getUserName()
        claims["roles"] = user.getRoles()

        return Jwts.builder()
            .setSubject(user.getUserName())
            .setClaims(claims)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact()
//        tokenStore.storeToken(token, username)
    }
}
