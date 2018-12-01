package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
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
	
}
