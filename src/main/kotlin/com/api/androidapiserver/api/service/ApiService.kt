package com.api.androidapiserver.api.service

import com.api.androidapiserver.api.dto.ApiDto
import com.api.androidapiserver.api.repository.ApiRepository
import org.springframework.stereotype.Service

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
class ApiService (val apiRepository: ApiRepository) {

    fun save(apiDto: ApiDto) {
        apiRepository.save(apiDto.toEntity(apiDto))
    }
}