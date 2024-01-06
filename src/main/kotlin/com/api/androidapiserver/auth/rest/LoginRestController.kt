package com.api.androidapiserver.auth.rest

import com.api.androidapiserver.api.dto.UserDto
import com.api.androidapiserver.api.service.ApiService
import com.api.androidapiserver.auth.jwt.JwtProvider
import com.api.androidapiserver.auth.service.WebUserDetailsService
import com.api.androidapiserver.auth.user.AccountUserDetails
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

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
class LoginRestController(val webUserDetailsService: WebUserDetailsService, val apiService: ApiService,
    private val passwordEncoder: PasswordEncoder) {

    @PostMapping("/login")
    fun login(userDto: UserDto) {

        webUserDetailsService.loadUserByUsername(userDto.userId)

        if(!passwordEncoder.matches(userDto.password, userDto.password)) {
            throw RuntimeException("패스워드가 맞지 않습니다.")
        }
    }
    @PostMapping("/join")
    fun join(userDto : UserDto) : ResponseEntity<String?> {
        return if(apiService.join(userDto)) {
            ResponseEntity.ok("회원가입이 완료되었습니다.")
        }else {
            ResponseEntity.ok("다시 시도해주세요.")
        }
    }

    @GetMapping("/logout")
    fun logout() {
    }
    @GetMapping("/profile/me")
    fun profile() : ResponseEntity<Any?> {
        val authentication = SecurityContextHolder.getContext().authentication
        val accountUserDetails = authentication.principal as Map<String, String>
        val userDetails = apiService.profile(accountUserDetails["userId"].toString())

        return ResponseEntity.ok(userDetails)
    }


}
