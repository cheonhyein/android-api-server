package com.api.androidapiserver.api.service

import com.api.androidapiserver.api.dto.ApiDto
import com.api.androidapiserver.api.dto.UserDto
import com.api.androidapiserver.api.entity.UserEntity
import com.api.androidapiserver.api.repository.ApiRepository
import com.api.androidapiserver.api.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.RuntimeException

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.service
 * </pre>
 *
 * @author
 * @since 2023/12/29
 */
@Service
class ApiService (val apiRepository: ApiRepository, val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder) {

    fun save(apiDto: ApiDto) {
        apiRepository.save(apiDto.toEntity(apiDto))
    }

    fun join(userDto : UserDto) : Boolean {
        val userEntity = UserEntity(userDto.userId, "a", passwordEncoder.encode(userDto.password), userDto.userName, "ROLE_USER")
        userRepository.save(userEntity)
        return true
    }

    fun profile(username : String) : UserEntity {
        return userRepository.findByUserId(username).orElseThrow { RuntimeException("Not found User Info.") }
    }
}
