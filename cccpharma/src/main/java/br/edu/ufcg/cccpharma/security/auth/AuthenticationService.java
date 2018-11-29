package br.edu.ufcg.cccpharma.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.security.JwtTokenProvider;
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
			String token = jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRoles());
			
			return token;
		} catch (AuthenticationException e) {
			throw new Exception("Invalid username/password supplied");
		}
	}


}
