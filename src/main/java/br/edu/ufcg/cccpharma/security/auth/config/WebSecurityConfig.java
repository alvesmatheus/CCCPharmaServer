package br.edu.ufcg.cccpharma.security.auth.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.edu.ufcg.cccpharma.role.UserRoleName;
import br.edu.ufcg.cccpharma.security.JwtTokenFilterConfigurer;
import br.edu.ufcg.cccpharma.security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
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
		
		http.cors();
		
		http.csrf().disable();
		
		http.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests()
			.antMatchers("/categories/**").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers("/sold-products/**").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers("/sales/**").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers(HttpMethod.POST, "/products").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers(HttpMethod.PUT, "/products").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers(HttpMethod.DELETE, "/products").hasAuthority(UserRoleName.ROLE_ADMIN.name())
			.antMatchers(HttpMethod.GET, "/products").permitAll()
			.antMatchers("/notifications/**").hasAuthority(UserRoleName.ROLE_ADMIN.name());
			
		
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// AuthenticationTokenFilter will ignore the below paths[
		web.ignoring().antMatchers(HttpMethod.POST, "/auth/signin");
	}


	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setExposedHeaders(Arrays.asList("Authorization"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
