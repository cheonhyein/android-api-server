package com.api.androidapiserver.auth.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.handler
 * </pre>
 *
 * @author
 * @since 1/4/24
 */

class LogoutHandler : SimpleUrlLogoutSuccessHandler() {

    override fun onLogoutSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        response?.sendRedirect("/");
    }


}
