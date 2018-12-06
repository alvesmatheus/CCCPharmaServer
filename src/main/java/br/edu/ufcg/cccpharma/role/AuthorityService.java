package br.edu.ufcg.cccpharma.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;

	public void save(Authority authority) {
		this.authorityRepository.save(authority);
	}

}
