package com.example.jpatwodb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表單提交
        http.formLogin()
            .failureForwardUrl("/login");

        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/users").authenticated()
            .antMatchers(HttpMethod.GET, "/users").hasAuthority("admin")
            .antMatchers(HttpMethod.GET).permitAll()
            .antMatchers(HttpMethod.POST).permitAll()
//            .anyRequest().authenticated()
            .anyRequest().permitAll()
            .and()
            .csrf().disable();
        // 異常處理
        http.exceptionHandling()
            //異常處理頁面
            .accessDeniedPage("/login");
//          .accessDeniedHandler(myAccessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //這裡設定passwordEncoder，就不需要初始化@Bean
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
