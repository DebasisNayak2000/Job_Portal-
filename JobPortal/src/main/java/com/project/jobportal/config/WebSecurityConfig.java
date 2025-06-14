package com.project.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//this need to be complete

import com.project.jobportal.services.CustomUserDetailsService;

@Configuration
public class WebSecurityConfig {
	
	private final CustomUserDetailsService customUserDetailsService;
	
	public WebSecurityConfig(CustomUserDetailsService customUserDetailsService) {
		super();
		this.customUserDetailsService = customUserDetailsService;
	}
	
	private final String[] publicUrl = {
			"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"
	};
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authenticationProvider(authenticationProvider());
		
		http.authorizeHttpRequests(auth ->{auth.requestMatchers( publicUrl).permitAll();
		                                   auth.anyRequest().authenticated();});
		return http.build();
	}
	
	@Bean
	private AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		return authenticationProvider;
		
	}
	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}


}
