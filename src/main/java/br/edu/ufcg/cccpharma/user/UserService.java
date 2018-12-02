package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return this.userRepository.save(user);
	}

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
