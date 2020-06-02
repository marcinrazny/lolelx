package com.cschool.marcinipiotrek.lolex.securityConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentialas, true from user where email =?")
                .authoritiesByUsernameQuery("select user_email as principal , role_name as rolle from user_roles where user_email=?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .antMatchers("/h2-console/**","/register", "/index","/", "/about", "/login","/advertisement_list", "/css/**", "/webjars/**","testSite").permitAll()
                .antMatchers("/profile","/mystore","/advertisement_add").hasAnyRole("USER, ADMIN")
                .antMatchers("/user_list").hasAnyRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
