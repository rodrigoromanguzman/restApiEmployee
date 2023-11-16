package com.example.restApiEmployee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); //No apto para producción
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequest(authorize-> authorize
//                        .requestMatchers(new AntPathMatcher("/","GET")).authenticated()
//                        .requestMatchers(new AntPathMatcher("/employees/**","GET")).hasAuthority("ADMIN")
//                ).csrf(csrf -> csrf.disable());
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/employees/**", "GET")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/**", "GET")).authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/**", "POST")).authenticated()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}





