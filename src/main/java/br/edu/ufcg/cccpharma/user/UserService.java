package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * An UserService object is responsible to establish the link between the
 * UserController and the UserRepository. Once the controller has interpreted
 * the received requests, the service will perform all the operations needed to
 * satisfy them. When database interaction is required, the UserService will use
 * its UserRepository attribute.
 * 
 * @author Douglas Pereira de Lima
 * @author Fanny Batista Vieira
 * @author Mateus de Lima Oliveira
 * @author Matheus Alves dos Santos
 * 
 * @since 2018-11-12
 * @version 1.0
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates a new User object in the system and returns it after that.
	 * 
	 * @param user The user to be created in the system.
	 * 
	 * @return The registered User object.
	 * 
	 */
	public User save(User user) {
		return this.userRepository.save(user);
	}

	/**
	 * Returns the User object whose e-mail address was given as parameter. If the
	 * given e-mail does not match one of the users in the system, this method will
	 * return null.
	 * 
	 * @param email The e-mail of the requested user.
	 * 
	 * @return The User object whose e-mail was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	/**
	 * Returns a list containing all the User objects in the system.
	 * 
	 * @return A list of all the Users.
	 * 
	 */
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	/**
	 * Deletes the User object whose identifier email was given as parameter. If
	 * the given email does not match one of the users in the system, nothing
	 * happens.
	 * 
	 * @param email The identifier email of the user to be deleted.
	 * 
	 * */
	public void deleteByEmail(String email) {
		this.userRepository.deleteByEmail(email);
	}
	
	/**
	 * Deletes all the User objects in the system.
	 */
	public void deleteAll() {
		this.userRepository.deleteAll();
	}

}
