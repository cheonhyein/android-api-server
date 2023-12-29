package com.api.androidapiserver.api.repository

import com.api.androidapiserver.api.entity.ApiEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.repository
 * </pre>
 *
 * @author
 * @since 2023/12/29
 */

interface ApiRepository : JpaRepository<ApiEntity, Long> {
}