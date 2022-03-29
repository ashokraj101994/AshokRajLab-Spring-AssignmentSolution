package com.greatlearning.StudentManagementSystem.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.StudentManagementSystem.Service.UserDetailServiceImp;

@Configuration
@EnableAutoConfiguration
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailServiceImp();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("Student/list", "Student/showFormForAdd", "Student/save", "/Student/403")
				.hasAnyAuthority("user,Admin").antMatchers("/Student/showFormForUpdate", "/Student/delete")
				.hasAnyAuthority("Admin").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/Student/list").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/Student/403").and().cors().and().csrf().disable();
	}
}
