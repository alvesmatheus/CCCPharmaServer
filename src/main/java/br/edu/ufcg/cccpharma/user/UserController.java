package br.edu.ufcg.cccpharma.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody User user) {
		/**
		 * TODO: Checar se o usuário existe
		 */
		return this.userService.save(user);
	}
	
	@GetMapping("/{email}")
	@ResponseStatus(HttpStatus.OK)
	public User findByEmail(@PathVariable String email){
		return this.userService.findByEmail(email);
	}
		
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll(){
		return this.userService.findAll();
	}
	
	
}
