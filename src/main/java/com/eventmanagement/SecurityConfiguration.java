package com.eventmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
                .build();
        UserDetails user1 = User.withDefaultPasswordEncoder().username("rahul").password("me").roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,user1);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .requestMatchers(HttpMethod.POST,"/events")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/events/**")
                .hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH,"/events/**")
                .hasRole( "ADMIN")
                .requestMatchers("/login/**")
                .anonymous()
                .anyRequest()
                .authenticated().and().csrf().disable();

        return http.build();

    }

}
