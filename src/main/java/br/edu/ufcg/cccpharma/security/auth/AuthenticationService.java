package br.edu.ufcg.cccpharma.security.auth;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.List;
import br.edu.ufcg.cccpharma.role.Authority;
import br.edu.ufcg.cccpharma.security.JwtTokenProvider;
import br.edu.ufcg.cccpharma.security.auth.config.AuthenticationConfig;
import br.edu.ufcg.cccpharma.user.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public String signin(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			List<Authority> authorities = userRepository.findByEmail(email).getRoles();			
			String token = jwtTokenProvider.createToken(email, authorities);
			
			JSONObject json = new JSONObject();
			json.put(AuthenticationConfig.TOKEN.toString(), token);
			json.put(AuthenticationConfig.ROLES.toString(), authorities);
	
			return json.toString();
			
		} catch (AuthenticationException e) {
			throw new Exception("Invalid username/password supplied");
		}
	}


}
