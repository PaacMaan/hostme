/**
 * 
 */
package com.hostme.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author rmidi
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
			.withUser("pacman").password("123456").roles("USER");*/
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//.loginPage("/login")
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").loginProcessingUrl("/login.do")
			.and()
				.csrf()
			.and()
				.authorizeRequests().antMatchers("/home").permitAll()
									.antMatchers("/ad").permitAll()
									.antMatchers("/register").permitAll()
									.antMatchers("/activate").permitAll()
									.antMatchers("/myads").access("hasRole('ROLE_USER')")
									.antMatchers("/add_ad").access("hasRole('ROLE_USER')")
									.antMatchers("/edit_ad/**").access("hasRole('ROLE_USER')")
									.antMatchers("/delete_ad/**").access("hasRole('ROLE_USER')")
									.antMatchers("/user/**").access("hasRole('ROLE_USER')")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}
	
	
}
