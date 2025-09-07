package com.example.EmployeeDB.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigurationDemo
{
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager jdbcUserDetailManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailManager.setUsersByUsernameQuery(
                "select user_id, pwd, active from members where user_id=?"
        );

        jdbcUserDetailManager.setAuthoritiesByUsernameQuery(
            "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(
                authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/members").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PATCH, "/api/members/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
