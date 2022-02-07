package perscholas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import perscholas.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				// Globally accessible without login/auth
				.antMatchers("/pub/**", "/error/**", "/login/**", "/search").permitAll()
				// Require authentication to access
				.antMatchers("/admin/**", "/user/**").authenticated()
				.and()
			.formLogin()
				// Login URL, displays JSP login
				.loginPage("/login/login")
				// URL where login page submit to be processed by Spring Security
				.loginProcessingUrl("/login/SecurityPost")
				.and()
			.logout()
				// Invalidates session to remove JSESSION_ID cookie from browser, Tomcat, & Spring Security
				.invalidateHttpSession(true)
				// URL that logs out user
				// Does not need a controller, handled by Spring Security
				.logoutUrl("/login/logout")
				// Redirect URL after logged out
				.logoutSuccessUrl("/")
				.and()
			.rememberMe()
				// Configuration for "Remember Me"
				.key("SR_KEY")
				.tokenValiditySeconds(60 * 60 * 24 * 2)
				.rememberMeParameter("remember-me")
				.and()
			.exceptionHandling()
				// In case of any access denied
				.accessDeniedPage("/error/404");
				
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPasswordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(getAuthenticationProvider());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}