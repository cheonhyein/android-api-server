package com.api.androidapiserver.api.entity

import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.entity
 * </pre>
 *
 * @author
 * @since 2023/12/29
 */
@Entity
@Table(name = "tb_android_api")
data class ApiEntity (
    @Id
    @Column(name = "SEQ", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq : Long? = null,

    @Column(name = "SRC_LANG_TYPE")
    val srcLangType : String? = null,

    @Column(name = "TAR_LANG_TYPE")
    val tarLangType : String? = null,

    @Column(name = "TRANSLATED_TEXT")
    val translatedText : String,

    @Column(name = "ENGINE_TYPE")
    val engineType : String? = null,

    @Column(name = "SOURCE")
    val source : String? = null,

    @Column(name = "CREATE_DATE")
    val createDate : LocalDateTime? = LocalDateTime.now()
)
