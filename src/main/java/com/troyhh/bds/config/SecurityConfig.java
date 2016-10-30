package com.troyhh.bds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // @formatter:off
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
          .antMatchers("/css/**", "/index").permitAll()
          .antMatchers("/user/**", "/greeting/**").hasRole("USER")
          .antMatchers("/dog/**").hasRole("SUPERDOG")
          .antMatchers("/cat/**").hasRole("FATCAT")
          .and()
        .formLogin().loginPage("/login").failureUrl("/login-error");
  }
  // @formatter:on

  // @formatter:off
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
    .inMemoryAuthentication()
      .withUser("rosco").password("x").roles("USER", "SUPERDOG");
    auth
    .inMemoryAuthentication()
      .withUser("ozzie").password("x").roles("USER", "FATCAT");
  }
  // @formatter:on
}