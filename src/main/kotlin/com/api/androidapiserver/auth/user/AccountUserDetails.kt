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

class AccountUserDetails(userId : String?, password : String?, userName : String?, authorities : Collection<out GrantedAuthority>?)
    : User(userId, password, authorities) {
 }
