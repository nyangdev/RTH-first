package com.example.RTH.config;

import com.example.RTH.security.UserDetailsServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login/loginMember")
                .loginPage("/login/login")
                .permitAll();

        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // 특정 URL에 대한 접근을 인증 없이 허용
                                .requestMatchers("/", "/js/**", "/css/**", "/image/**", "/main", "/about", "/job", "/sell", "/buy", "/login/**", "/join/**", "/error").permitAll()
                                // 다른 모든 요청은 인증이 필요
                                .anyRequest().authenticated()
                );

        return http.build();
    }
}