package com.api.androidapiserver.api.dto

import jakarta.persistence.Column

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.dto
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

data class UserDto(

    val userId: String,

    val password: String,

    val userName: String
)
