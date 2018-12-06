package br.edu.ufcg.cccpharma.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
	@PostMapping("/client")
	public void saveAuthorityClient() {
		Authority authority = new Authority(1, UserRoleName.ROLE_CLIENT);
		this.authorityService.save(authority);	
	}
	
	@PostMapping("/admin")
	public void saveAuthorityAdmin() {
		Authority authority = new Authority(2, UserRoleName.ROLE_ADMIN);
		this.authorityService.save(authority);
	}
	
	@GetMapping
	public List<Authority> findAll(){
		return this.authorityService.findAll();
	}
	

}
