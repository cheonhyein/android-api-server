package com.api.androidapiserver.api.tokenstore

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

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
@Configuration
class InMemoryTokenStore : TokenStore {

    private val tokenStore : ConcurrentHashMap<String, Any> = ConcurrentHashMap()
    override fun storeToken(token: String, username: String) {
        tokenStore[token] = username
    }

    override fun removeToken(token: String) {
        tokenStore.remove(token)
    }

    override fun readUsername(token: String): String {
        return tokenStore[token].toString()
    }

    override fun validateToken(token: String): Boolean {
        return tokenStore.containsKey(token)
    }
}
