package com.api.androidapiserver.api.dto

import java.util.Date

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.dto
 * </pre>
 *
 * @author
 * @since 1/6/24
 */

data class UserDetailDto(

    val token: String,

    val expirationDate : Date,

    val roles: MutableList<String>
)
