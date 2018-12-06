package br.edu.ufcg.cccpharma.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import br.edu.ufcg.cccpharma.role.Authority;
import br.edu.ufcg.cccpharma.security.auth.config.AuthenticationConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	
	@Value("${security.jwt.token.expire-length}")
	private long validityInMilliseconds;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String email, List<Authority> roles) {
		Claims claims = Jwts.claims().setSubject(email);
		claims.put(AuthenticationConfig.ROLES.toString(), roles);
		
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		
		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(validity)
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}
	
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(getEmail(token));
		
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public String getEmail(String token) {
		return Jwts.parser()
			.setSigningKey(secretKey)
			.parseClaimsJws(token).getBody()
			.getSubject();
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader(AuthenticationConfig.HEADER.toString());
		
		if(bearerToken != null && bearerToken.startsWith(AuthenticationConfig.TOKEN_PREFIX.toString())) {
			return bearerToken.substring(7, bearerToken.length());
		}
		
		return null;
	}
	
	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
		
			if(claims.getBody().getExpiration().before(new Date())) {
				return false;
			}
			
			return true;
			
		}catch(JwtException | IllegalArgumentException e) {
			throw new JwtException("Expired or Invalid Jwt token");
		}
	}

}
