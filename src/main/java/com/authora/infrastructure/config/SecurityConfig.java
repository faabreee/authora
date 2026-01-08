package com.authora.infrastructure.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/.well-known/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("http://localhost:3000");
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    config.setAllowCredentials(true);
                    return config;
                }))
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .successHandler((request, response, authentication) ->
                            manageRedirect(request, response)
                        )
                )
        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user1")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public void manageRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var savedRequest = new HttpSessionRequestCache().getRequest(request, response);
        if (savedRequest != null) {
            response.sendRedirect(savedRequest.getRedirectUrl());
        } else {
            response.sendRedirect("/");
        }
    }

}
