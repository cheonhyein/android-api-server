package com.api.androidapiserver.api.tokenstore

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.api.tokenstore
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

interface TokenStore {
    /** 저장 */
    fun storeToken(token : String, username :String)

    /** 삭제 */
    fun removeToken(token : String)

    /** 조회 */
    fun readUsername(token : String) : String

    fun validateToken(token : String) : Boolean



}
