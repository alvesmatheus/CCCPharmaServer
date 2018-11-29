package br.edu.ufcg.cccpharma.security.auth;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.cccpharma.security.auth.config.AuthenticationConfig;


@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signin")
	public String signin(@RequestBody AuthenticationUser userAuth) throws Exception {
		String email = userAuth.getEmail();
		String password = userAuth.getPassword();
		String token = this.authenticationService.signin(email, password);
		
		JSONObject json = new JSONObject();
		json.put(AuthenticationConfig.TOKEN.toString(), token);
		
		return json.toString();
	}

}
