package com.security.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception{

        //disabling the CSRF
        http.csrf(customizer  -> customizer.disable());

        //enabling security for rqeuest
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        //basic form login page will appear
        http.formLogin(Customizer.withDefaults());
        //postman will also work if we will hit the endpoint
        http.httpBasic(Customizer.withDefaults());

        //to make session stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();


    }

}
