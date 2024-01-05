package com.api.androidapiserver.api.repository

import com.api.androidapiserver.api.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.repository
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

interface UserRepository : JpaRepository< UserEntity, String> {

    fun findByUserId(userId : String) : Optional<UserEntity>
}
