package com.example.EmployeeDemoProject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurationDemo
{
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        UserDetails john = User.builder()
                .username("John")
                .password("{noop}john")
                .roles("EMPLOYEE")
                .build();

        UserDetails mery = User.builder()
                .username("Mery")
                .password("{noop}mery")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susan")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mery, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configure ->
                configure
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
