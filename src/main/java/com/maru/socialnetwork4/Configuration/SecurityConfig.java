package com.maru.socialnetwork4.Configuration;

import com.maru.socialnetwork4.Utils.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                    .disable()
                .cors()
                .and()
                .csrf()
                    .disable()
                .authorizeHttpRequests()
                .antMatchers("/user/signIn", "/user/signUp")
                    .permitAll()
                .antMatchers("user/update")
                    .authenticated()
                .antMatchers("/post/getAllPosts")
                    .hasAuthority("ADMIN")
                .anyRequest()
                    .denyAll()
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
