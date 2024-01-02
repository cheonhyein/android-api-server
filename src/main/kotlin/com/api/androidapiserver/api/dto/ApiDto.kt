package com.api.androidapiserver.api.dto

import com.api.androidapiserver.api.entity.ApiEntity

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.dto
 * </pre>
 *
 * @author
 * @since 2023/12/29
 */

data class ApiDto (
    val seq : Long? = null,

    val srcLangType : String? = null,

    val tarLangType : String? = null,

    val translatedText : String,

    val source : String? = null,

    val engineType : String? = null
) {
    fun toEntity(apiDto: ApiDto) : ApiEntity {
        return ApiEntity(
            apiDto.seq,
            apiDto.srcLangType,
            apiDto.tarLangType,
            apiDto.translatedText,
            apiDto.engineType,
            apiDto.source,
        )
    }
}
