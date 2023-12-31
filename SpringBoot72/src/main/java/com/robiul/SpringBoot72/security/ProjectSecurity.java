package com.robiul.SpringBoot72.security;


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
public class ProjectSecurity {

    private  final UserDetailsService userDetailsService;

    public ProjectSecurity(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
//
//        http
//                .authorizeRequests()
//                .requestMatchers("/public/**, /user/**")
//                .hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//
//                .and()
//
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
//                .userDetailsService(userDetailsService);
//
//        return  http.build();
//    }



    @Bean
    public  SecurityFilterChain filterChain (HttpSecurity http) throws  Exception{

        http
                .authorizeHttpRequests((authrize) -> authrize
                        .requestMatchers("/admin/**").authenticated()
                )

                .authorizeHttpRequests((authrize) -> authrize
                        .requestMatchers("/public/**").permitAll()
                )

                .authorizeHttpRequests((authrize) -> authrize
                        .requestMatchers("/user/**").permitAll()
                )

                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());


                return http.build();
    }

}
