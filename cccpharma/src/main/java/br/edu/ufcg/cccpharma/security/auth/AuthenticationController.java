package br.edu.ufcg.cccpharma.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signin")
	public String signin(@RequestParam(value = "email") String email, 
			@RequestParam(value = "password") String password) throws Exception {
		return this.authenticationService.signin(email, password);
	}

}
