package com.sevar.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sevar.user.userdetails.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{

	@Bean
	public UserDetailsService detailsService()
	{
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("all")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		// URL And Levels
				http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/user/create").permitAll()
				.requestMatchers("/user/").hasAuthority("USER")
				.anyRequest().authenticated()
				.and()
				
				
				.formLogin()
				
				.and()
				
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
				
				return http.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
			DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(detailsService());
			authenticationProvider.setPasswordEncoder(encoder());
			return authenticationProvider;
	}
	
	
}
