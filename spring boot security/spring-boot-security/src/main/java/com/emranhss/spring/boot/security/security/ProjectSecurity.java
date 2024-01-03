package com.emranhss.spring.boot.security.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurity {

    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http
                .authorizeHttpRequests( ( authorize )-> authorize
                        .requestMatchers("/admin/**").authenticated()
                )

                .authorizeHttpRequests( ( authorize )-> authorize
                        .requestMatchers("/public/**").permitAll()
                )


                .httpBasic( Customizer.withDefaults() )
                .formLogin( Customizer.withDefaults() );

            return http.build();

    }
}
