package com.houserent.HouseRent.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securitys {


    private UserDetailsService userDetailsService;

    @Autowired
    public Securitys(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((au) -> au
                        .requestMatchers("/", "/assets/**")
                        .permitAll()
                        .requestMatchers("/owner/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/**")
                        .hasRole("USER")
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .userDetailsService(userDetailsService);

        return http.build();
    }
}
