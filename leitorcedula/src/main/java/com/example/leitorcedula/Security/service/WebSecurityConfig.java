package com.example.leitorcedula.Security.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "/criar").permitAll()
                                .requestMatchers(HttpMethod.GET, "/livre").permitAll())
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers(HttpMethod.GET, "/conteudo").authenticated())
                .httpBasic(Customizer.withDefaults())
;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();    
    }


    @Bean
    public UserDetailsService myUserDetailsService() {
        return new UsuarioDetailsService();
    }
}
