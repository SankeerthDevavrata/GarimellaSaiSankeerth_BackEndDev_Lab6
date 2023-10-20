package com.gl.lab6.studentRegistration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.gl.lab6.studentRegistration.service.UserDetailsServiceImp;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	DataSource dataSource;
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsServiceImp();
//	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//
//		return authProvider;
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.authenticationProvider(authenticationProvider());
		auth.jdbcAuthentication().dataSource(dataSource)
		.withDefaultSchema()
		.withUser(User.withUsername("Krishna").password(passwordEncoder().encode("Krishna")).roles("ADMIN"))
		.withUser(User.withUsername("Sankeerth").password(passwordEncoder().encode("Sankeerth")).roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/registrations", "/registrations/new", "/registrations/search").hasAnyRole("USER", "ADMIN")
		.antMatchers("/registrations/edit/{id}", "/registrations/{id}").hasRole("ADMIN")
		.antMatchers("/","/registrations/search").permitAll()
		.and().formLogin()
		.and().cors().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

}
