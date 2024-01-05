package com.api.androidapiserver.auth.service

import com.api.androidapiserver.api.entity.UserEntity
import com.api.androidapiserver.api.repository.UserRepository
import com.api.androidapiserver.auth.user.AccountUserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.Arrays
import java.util.stream.Collector

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth
 * </pre>
 *
 * @author
 * @since 1/5/24
 */
@Service
class WebUserDetailsService() : UserDetailsService {
//    private val userRepository: UserRepository
    override fun loadUserByUsername(username: String): UserDetails {
//        var userEntity = userRepository.findByUserId(username).orElseThrow { RuntimeException("Not found User Info.") }
        var userEntity = UserEntity("hyein", "a", "1", "천혜인","ROLE_USER,ROLE_ADMIN", LocalDateTime.now())

//        val authorities: List<GrantedAuthority> = Arrays.stream((userEntity).role.split(","))
//            .map { SimpleGrantedAuthority(it) }
//            .toList()
        return AccountUserDetails(userEntity.userId, userEntity.password, userEntity.userName, null)

    }
}
