package com.api.androidapiserver.auth.config

import com.api.androidapiserver.api.tokenstore.InMemoryTokenStore
import com.api.androidapiserver.auth.handler.LoginHandler
import com.api.androidapiserver.auth.handler.LogoutHandler
import com.api.androidapiserver.auth.jwt.JwtFilter
import com.api.androidapiserver.auth.jwt.JwtProvider
import com.api.androidapiserver.auth.service.WebUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

/**
 * <pre>
 *
 *
 * Description : com.api.androidapiserver.auth.config
 * </pre>
 *
 * @author
 * @since 1/3/24
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig(
//    private val webUserDetailsService: WebUserDetailsService,
    private val inMemoryTokenStore: InMemoryTokenStore,
    private val jwtProvider: JwtProvider
) {

    @Bean
    fun filterChain(http : HttpSecurity) : SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers("/api/profile/me").hasAuthority("ROLE_USER")
                    .requestMatchers("/login, /api").permitAll()
                    .requestMatchers("/authorize/**").authenticated()
            }
            .formLogin { login ->
                login
                    .loginPage("/login")
//                    .loginProcessingUrl("/login")
                    .successHandler(LoginHandler())
            }
            .logout { logout ->
                logout
                    .logoutUrl("/logout")
            }
            .addFilterBefore(JwtFilter(inMemoryTokenStore, jwtProvider), UsernamePasswordAuthenticationFilter::class.java)
            .httpBasic(Customizer.withDefaults())
        return http.build()
    }

//    fun userDetailsService() : UserDetailsService {
//        return webUserDetailsService
//    }

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }


}
