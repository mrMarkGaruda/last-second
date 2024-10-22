package com.bagdouri.lastsecond.lastsecondflight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Require HTTPS for all requests
                .requiresChannel(channel -> channel.anyRequest().requiresSecure());
        return http.build();
    }
}
