package com.basic.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuild) throws Exception {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();


        InMemoryUserDetailsManager inMemory=new InMemoryUserDetailsManager();

        UserDetails user=   User.withUsername("sagarapi")
                                .password(passwordEncoder.encode("sagarapi"))
                                .authorities("read")
                                .build();

        inMemory.createUser(user);
        authManagerBuild.userDetailsService(inMemory).passwordEncoder(passwordEncoder);
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests().anyRequest().authenticated();

    }

}
