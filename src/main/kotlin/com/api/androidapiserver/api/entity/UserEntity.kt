package com.api.androidapiserver.api.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.entity
 * </pre>
 *
 * @author
 * @since 1/4/24
 */
@Entity
@Table(name = "tb_android_user")
data class UserEntity(

    @Id
    @Column(name = "USER_ID", length = 36, nullable = false)
    val userId: String,

    @Column(name = "COMPANY_ID", length = 36, nullable = false)
    val companyId: String,

    @Column(name = "PASSWORD", length = 255, nullable = false)
    val password: String,

    @Column(name = "USER_NAME", length = 100, nullable = false)
    val userName: String,

    @Column(name = "ROLES", length = 50)
    val roles : String,

    @Column(name = "CREATE_DATE")
    val createDate : LocalDateTime? = LocalDateTime.now()

)


