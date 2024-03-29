package com.yedam.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean // == @Component
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CustomSuccessHandler authenticationSuccessHandler() {
		return new CustomSuccessHandler();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
//			.authorizeHttpRequests((requests) -> requests
//				.antMatchers("/", "/home").permitAll()
//				.antMatchers("/emp/**").hasRole("admin")
//				.anyRequest().authenticated()
//			)
			.authorizeHttpRequests()
				.antMatchers("/", "/home").permitAll()
				/*.antMatchers("/emp/**").hasRole("admin")*/.anyRequest().authenticated()
				.and()
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
			.formLogin()
				.successHandler(authenticationSuccessHandler())
				.loginPage("/login")
				.permitAll()
				.and()
				.logout((logout) -> logout.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}