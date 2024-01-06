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
class WebUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): AccountUserDetails {
        val userEntity = userRepository.findByUserId(username).orElseThrow { RuntimeException("Not found User Info.") }
        val rolesList : MutableList<String> = userEntity.roles.split(",").toMutableList()
        val authority = rolesList.map { role -> SimpleGrantedAuthority("$role") }
        return AccountUserDetails(userEntity.userId, userEntity.password, userEntity.userName, rolesList, authority)

    }
}
