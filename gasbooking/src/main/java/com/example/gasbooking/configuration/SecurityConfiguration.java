package com.example.gasbooking.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select customer_name as customer_name, customer_password,admin_enabled"
								+ " from customer where customer_name=?")
				.authoritiesByUsernameQuery(
						"select customer_name as customer_name, roles" + " from customer where customer_name=?")
				.passwordEncoder(new BCryptPasswordEncoder());
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/actuator/**").permitAll().antMatchers("/dashboard")
				.permitAll().antMatchers("/booking", "/payment", "/feedback", "/myprofile","/mybooking").hasAuthority("ROLE_USER")
				.antMatchers("/gasstock","/gasentry","/feedbackentry","/verifycustomer","/customerdetails").hasAuthority("ROLE_ADMIN").and()
				.formLogin().loginPage("/signin").defaultSuccessUrl("/dashboard", true).failureUrl("/signin?error=Invalid username and password")
				.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/accessdenied");

	}
}