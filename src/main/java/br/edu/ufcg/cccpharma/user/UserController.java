package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * An UserController object is responsible to manage the users of the CCCPharma
 * system based on the requests received. Once that the operations are usually
 * delegated to the service attribute, the main purposes of this controller are
 * to invoke the proper services based on the received requests and to define
 * the response status used on them.
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
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Creates a new User object in the system and returns it after that. Also, uses
	 * the HTTP status 201.
	 * 
	 * @param user The user to be created in the system.
	 * 
	 * @return The registered User object.
	 * 
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		return this.userService.save(user);
	}

	/**
	 * Returns the User object whose e-mail address was given as parameter. If the
	 * given e-mail does not match one of the users in the system, this method will
	 * return null. Also, uses the HTTP status 200.
	 * 
	 * @param email The e-mail of the requested user.
	 * 
	 * @return The User object whose e-mail was given, if it exists. Null,
	 *         otherwise.
	 * 
	 */
	@GetMapping("/{email}")
	@ResponseStatus(HttpStatus.OK)
	public User findByEmail(@PathVariable String email) {
		return this.userService.findByEmail(email);
	}

	/**
	 * Returns a list containing all the User objects in the system. Uses the HTTP
	 * status 200.
	 * 
	 * @return A list of all the Users.
	 * 
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll() {
		return this.userService.findAll();
	}
	
	
	/**
	 * Deletes all the user objects in the system. Also, uses the HTTP status
	 * 200.
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteAll() {
		this.userService.deleteAll();
	}
	
	/**
	 * Deletes the User object whose identifier email was given as parameter. If
	 * the given email does not match one of the users in the system, nothing
	 * happens. Also, uses the HTTP status 200.
	 * 
	 * @param email The identifier email of the user to be deleted.
	 * 
	 */
	@DeleteMapping("/{email}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteByEmail(@PathVariable String email) {
		this.userService.deleteByEmail(email);
	}


}
