package com.api.androidapiserver.auth.rest

import com.api.androidapiserver.api.dto.UserDto
import com.api.androidapiserver.auth.jwt.JwtProvider
import com.api.androidapiserver.auth.service.WebUserDetailsService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.rest
 * </pre>
 *
 * @author
 * @since 1/3/24
 */
@RestController
@RequestMapping
class LoginRestController(val webUserDetailsService: WebUserDetailsService, val jwtProvider: JwtProvider) {

    @GetMapping("/login")
    fun login(userDto: UserDto) : ResponseEntity<String> {
        var userDetails = webUserDetailsService.loadUserByUsername(userDto.userId)
        return ResponseEntity.ok(jwtProvider.createJwtToken(userDetails.username))
    }

    @GetMapping("/logout")
    fun logout() {
    }



}
