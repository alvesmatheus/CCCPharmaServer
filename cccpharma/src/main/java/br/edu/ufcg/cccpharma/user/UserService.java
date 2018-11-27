package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.edu.ufcg.cccpharma.security.JwtTokenProvider;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public User save(User user) {
		/**
		 * TODO: Implementar validação.
		 */
		return this.userRepository.save(user);
	}
	
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	
	public String signin(String email, String password) throws Exception {
		System.out.println(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRoles());
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			throw new Exception("Invalid username/password supplied");
		}
	}
	
	
}
