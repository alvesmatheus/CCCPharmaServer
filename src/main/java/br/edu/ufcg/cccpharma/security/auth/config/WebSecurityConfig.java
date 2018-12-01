package br.edu.ufcg.cccpharma.security.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.edu.ufcg.cccpharma.security.JwtTokenFilterConfigurer;
import br.edu.ufcg.cccpharma.security.JwtTokenProvider;

@Configuration
@EnableAutoConfiguration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.csrf().disable();
		
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests()
			.antMatchers("/users").authenticated();
		
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// AuthenticationTokenFilter will ignore the below paths
		web.ignoring().antMatchers(HttpMethod.POST, "/auth/signin");
	}
}
