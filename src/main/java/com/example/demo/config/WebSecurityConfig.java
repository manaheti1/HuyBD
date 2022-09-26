package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.impl.UserDetailServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.httpBasic().disable();
		http.authorizeRequests().antMatchers("/v2/*").access("hasRole('ROLE_ADMIN')");
//		http.authorizeRequests().and().formLogin()//
//		// Submit URL of login page.
//		.loginProcessingUrl("/j_spring_security_check")// Submit URL/action form
//		.loginPage("/movie-theater/login")//
//		.defaultSuccessUrl("/movie-theater/dashboard")
////.successHandler(customAuthenticationSuccessHandler)
//		.failureUrl("/movie-theater/exceptions")//
//		.usernameParameter("username")//
//		.passwordParameter("password")
//		// Config for Logout Page
//		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/movie-theater/login");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

}
