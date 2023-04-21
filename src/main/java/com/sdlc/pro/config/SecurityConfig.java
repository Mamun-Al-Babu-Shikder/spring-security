package com.sdlc.pro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return
                http
                        .authorizeRequests()
                        .antMatchers("/home").permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .httpBasic()
                        .and()
                        .csrf()
                        .disable()
                        .build();
    }
}