/**
 * 
 */
package com.cwp.alice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.cwp.alice.authentication.CustomAuthenticationService;
import com.cwp.alice.constants.GenericConstants;

/**
 * @author lugupta
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationService customAuthenticationService;

	@Autowired
	@Order(1)
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customAuthenticationService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customAuthenticationService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers(GenericConstants.URL_SLASH, GenericConstants.URL_LOGIN, GenericConstants.URL_LOGOUT)
				.permitAll();

		http.authorizeRequests()
				.antMatchers(GenericConstants.URL_CW_DASHBOARD, GenericConstants.URL_CW_CASE_CREATE,
						GenericConstants.URL_CW_APPOINTMENT, GenericConstants.URL_CW_ACCOUNT_DETAILS)
				.hasRole(GenericConstants.ROLE_ADMIN);

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage(GenericConstants.URL_ACCESSDENIED);

		http.authorizeRequests().and().formLogin().loginProcessingUrl("/j_spring_security_check")
				.loginPage(GenericConstants.URL_LOGIN).defaultSuccessUrl(GenericConstants.URL_CW_DASHBOARD)
				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password").and()
				.logout().deleteCookies("JSESSIONID").logoutUrl(GenericConstants.URL_LOGOUT)
				.logoutSuccessUrl(GenericConstants.URL_LOGOUTSUCCESS);

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		http.sessionManagement().sessionFixation().newSession();
		http.sessionManagement().maximumSessions(GenericConstants.MAX_SESSIONS)
				.expiredUrl(GenericConstants.URL_SESSIONEXPIRED);
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

}