package com.api.androidapiserver.auth.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User


/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.user
 * </pre>
 *
 * @author
 * @since 1/5/24
 */

class AccountUserDetails(userId : String?, password : String?, private val userName : String, private val roles : MutableList<String>, authorities : Collection<out GrantedAuthority>?)
    : User(userId, password, authorities) {

        fun getRoles() : MutableList<String> {
            return roles
        }

        fun getUserName() : String{
            return userName
        }

    }
